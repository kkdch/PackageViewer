package com.samsung.chenhandai.packageviewer;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenhan.dai on 8/29/16.
 */
public class PkgListFragment extends Fragment {
    AppInfoAdapter mPkgListAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<AppInfo> list = new ArrayList<>();
        List<ApplicationInfo> applicationInfoList = getActivity().getPackageManager().getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo applicationInfo : applicationInfoList) {
            AppInfo appInfo = new AppInfo();
            appInfo.setName(getActivity().getPackageManager().getApplicationLabel(applicationInfo).toString());
            appInfo.setIcon(getActivity().getPackageManager().getApplicationIcon(applicationInfo));
            list.add(appInfo);
        }
        mPkgListAdapter = new AppInfoAdapter(
                getActivity(),
                R.layout.grid_item_pkglist,
                list
        );
        View rootView = inflater.inflate(R.layout.fragment_pkglist, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_view_pkglist);
        gridView.setAdapter(mPkgListAdapter);
        return rootView;
    }
}
