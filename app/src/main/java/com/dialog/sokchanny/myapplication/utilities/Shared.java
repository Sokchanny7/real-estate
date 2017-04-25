package com.dialog.sokchanny.myapplication.utilities;

import com.dialog.sokchanny.myapplication.controller.Main.HomeActivity;
import com.dialog.sokchanny.myapplication.controller.detail.HouseDetailActivity;
import com.dialog.sokchanny.myapplication.controller.favorite.FavoriteFragment;
import com.dialog.sokchanny.myapplication.controller.more.MoreFragment;
import com.dialog.sokchanny.myapplication.controller.nearbypost.NearByFragment;
import com.dialog.sokchanny.myapplication.controller.newpost.NewPostFragment;

/**
 * Created by sokchanny on 3/28/17.
 */


public class Shared {

    public static HomeActivity      homeActivity;
    public static NewPostFragment   newPostFragment;
    public static NearByFragment    nearByFragment;
    public static FavoriteFragment  favoriteFragment;
    public static MoreFragment      moreFragment;
    public static HouseDetailActivity houseDetailActivity;

//    public static class ItemType {
//        public static final int HOUSE_DETAIL    = 1;
//        public static final int HOUSE_COMMENT   = 2;
//    }
//
//    public class FragmentType {
//        public static final int NEW_POST        = 1;
//        public static final int NEAR_BY_POST    = 2;
//        public static final int FAVORITE        = 3;
//        public static final int MORE            = 4;
//    }
}
