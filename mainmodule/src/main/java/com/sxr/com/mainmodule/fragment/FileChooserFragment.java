package com.sxr.com.mainmodule.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.R;
import com.vincent.filepicker.Constant;
import com.vincent.filepicker.activity.AudioPickActivity;
import com.vincent.filepicker.activity.ImagePickActivity;
import com.vincent.filepicker.activity.NormalFilePickActivity;
import com.vincent.filepicker.activity.VideoPickActivity;
import com.vincent.filepicker.filter.entity.AudioFile;
import com.vincent.filepicker.filter.entity.ImageFile;
import com.vincent.filepicker.filter.entity.NormalFile;
import com.vincent.filepicker.filter.entity.VideoFile;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;
import static com.vincent.filepicker.activity.AudioPickActivity.IS_NEED_RECORDER;
import static com.vincent.filepicker.activity.BaseActivity.IS_NEED_FOLDER_LIST;
import static com.vincent.filepicker.activity.ImagePickActivity.IS_NEED_CAMERA;


public class FileChooserFragment extends Fragment {

    private Button mChooseBtn;
    private TextView mTvResult;
    private Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity = getActivity();
        View view = inflater.inflate(R.layout.fragment_file_chooser, container, false);
        initWidget(view);
        return view;
    }

    private void initWidget(View root) {
        mTvResult = root.findViewById(R.id.tv_result);
        mChooseBtn = root.findViewById(R.id.file_chooser_btn);
        mChooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] stringItems = {"选择图像", "选择视频", "选择音频", "选择文档"};
                final ActionSheetDialog dialog = new ActionSheetDialog(mActivity, stringItems, null);
                dialog.title("选择文件")//
                        .titleTextSize_SP(14.5f)//
                        .show();

                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Logger.e("position: " + position + "; id: " + id);
                        switch (position) {
                            case 0:
                                Intent intent1 = new Intent(mActivity, ImagePickActivity.class);
                                intent1.putExtra(IS_NEED_CAMERA, true);
                                intent1.putExtra(Constant.MAX_NUMBER, 9);
                                intent1.putExtra(IS_NEED_FOLDER_LIST, true);
                                startActivityForResult(intent1, Constant.REQUEST_CODE_PICK_IMAGE);
                                break;
                            case 1:
                                Intent intent2 = new Intent(mActivity, VideoPickActivity.class);
                                intent2.putExtra(IS_NEED_CAMERA, true);
                                intent2.putExtra(Constant.MAX_NUMBER, 9);
                                intent2.putExtra(IS_NEED_FOLDER_LIST, true);
                                startActivityForResult(intent2, Constant.REQUEST_CODE_PICK_VIDEO);
                                break;
                            case 2:
                                Intent intent3 = new Intent(mActivity, AudioPickActivity.class);
                                intent3.putExtra(IS_NEED_RECORDER, true);
                                intent3.putExtra(Constant.MAX_NUMBER, 9);
                                intent3.putExtra(IS_NEED_FOLDER_LIST, true);
                                startActivityForResult(intent3, Constant.REQUEST_CODE_PICK_AUDIO);
                                break;
                            case 3:
                                Intent intent4 = new Intent(mActivity, NormalFilePickActivity.class);
                                intent4.putExtra(Constant.MAX_NUMBER, 9);
                                intent4.putExtra(IS_NEED_FOLDER_LIST, true);
                                intent4.putExtra(NormalFilePickActivity.SUFFIX,
                                        new String[]{"xlsx", "xls", "doc", "docx", "ppt", ".pptx", "pdf"});
                                startActivityForResult(intent4, Constant.REQUEST_CODE_PICK_FILE);
                                break;
                        }
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Constant.REQUEST_CODE_PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    ArrayList<ImageFile> list = data.getParcelableArrayListExtra(Constant.RESULT_PICK_IMAGE);
                    StringBuilder builder = new StringBuilder();
                    for (ImageFile file : list) {
                        String path = file.getPath();
                        builder.append(path + "\n");
                    }
                    mTvResult.setText(builder.toString());
                }
                break;
            case Constant.REQUEST_CODE_PICK_VIDEO:
                if (resultCode == RESULT_OK) {
                    ArrayList<VideoFile> list = data.getParcelableArrayListExtra(Constant.RESULT_PICK_VIDEO);
                    StringBuilder builder = new StringBuilder();
                    for (VideoFile file : list) {
                        String path = file.getPath();
                        builder.append(path + "\n");
                    }
                    mTvResult.setText(builder.toString());
                }
                break;
            case Constant.REQUEST_CODE_PICK_AUDIO:
                if (resultCode == RESULT_OK) {
                    ArrayList<AudioFile> list = data.getParcelableArrayListExtra(Constant.RESULT_PICK_AUDIO);
                    StringBuilder builder = new StringBuilder();
                    for (AudioFile file : list) {
                        String path = file.getPath();
                        builder.append(path + "\n");
                    }
                    mTvResult.setText(builder.toString());
                }
                break;
            case Constant.REQUEST_CODE_PICK_FILE:
                if (resultCode == RESULT_OK) {
                    ArrayList<NormalFile> list = data.getParcelableArrayListExtra(Constant.RESULT_PICK_FILE);
                    StringBuilder builder = new StringBuilder();
                    for (NormalFile file : list) {
                        String path = file.getPath();
                        builder.append(path + "\n");
                    }
                    mTvResult.setText(builder.toString());
                }
                break;
        }
    }
}
