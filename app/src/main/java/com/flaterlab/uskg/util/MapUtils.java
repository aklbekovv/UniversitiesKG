package com.flaterlab.uskg.util;

import android.webkit.JavascriptInterface;

import com.flaterlab.uskg.models.Campus;

public class MapUtils {

    public static class MapInterface {
        private Campus campus;

        public MapInterface(Campus campus) {
            this.campus = campus;
        }

        @JavascriptInterface
        public double getLatitude() {
            return campus.getLatitude();
        }

        @JavascriptInterface
        public double getLongitude() {
            return campus.getLongitude();
        }
    }
}
