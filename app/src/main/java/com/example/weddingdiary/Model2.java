package com.example.weddingdiary;

public class Model2 {


    String mPackageName;
    String mPackageDetail;
    int mPackagePhoto;

    public Model2(String mPackageName, String mPackageDetail, int mPackagePhoto) {
        this.mPackageName = mPackageName;
        this.mPackageDetail = mPackageDetail;
        this.mPackagePhoto = mPackagePhoto;
    }




    public String getmPackageName() {
        return mPackageName;
    }

    public String getmPackageDetail() {
        return mPackageDetail;
    }

    public int getmPackagePhoto() {
        return mPackagePhoto;
    }
}
