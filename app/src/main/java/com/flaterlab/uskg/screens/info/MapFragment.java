package com.flaterlab.uskg.screens.info;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.flaterlab.uskg.R;
import com.flaterlab.uskg.util.CommonUtils;
import com.flaterlab.uskg.util.InjectorUtils;
import com.flaterlab.uskg.viewmodels.UniversityListViewModel;

import static com.flaterlab.uskg.util.AppConstants.MAP_HTML_PATH;

public class MapFragment extends Fragment {
    private UniversityListViewModel viewModel;
    private WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(
                requireActivity(),
                InjectorUtils.getInstance().provideUniversityListViewModelFactory(requireContext())
        ).get(UniversityListViewModel.class);

        initMap();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initMap() {
        webView = new WebView(requireContext());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(MAP_HTML_PATH);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(true);

        Display display = requireActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        int appBarHeight = CommonUtils.getActionBarSize(requireContext());
        int height = point.y - 4 * appBarHeight;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, height);
        webView.setLayoutParams(params);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return webView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webView.requestFocus();
    }
}
