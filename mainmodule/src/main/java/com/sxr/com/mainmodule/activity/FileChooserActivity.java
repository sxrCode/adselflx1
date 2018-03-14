package com.sxr.com.mainmodule.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.FileChooserFragment;
import com.vincent.filepicker.Constant;
import com.vincent.filepicker.filter.entity.AudioFile;
import com.vincent.filepicker.filter.entity.ImageFile;
import com.vincent.filepicker.filter.entity.NormalFile;
import com.vincent.filepicker.filter.entity.VideoFile;

import java.util.ArrayList;


public class FileChooserActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new FileChooserFragment();
    }
}
