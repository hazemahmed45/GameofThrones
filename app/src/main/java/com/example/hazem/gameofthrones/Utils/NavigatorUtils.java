package com.example.hazem.gameofthrones.Utils;

import android.app.Activity;
import android.content.Intent;

import com.example.hazem.gameofthrones.Base.Constants.NavConstants;
import com.example.hazem.gameofthrones.Features.Activity.BookScreen;
import com.example.hazem.gameofthrones.Features.Activity.CharacterScreen;
import com.example.hazem.gameofthrones.Features.Activity.HouseScreen;
import com.example.hazem.gameofthrones.Models.Books;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.Models.Houses;

/**
 * Created by Hazem on 6/22/2017.
 */

public class NavigatorUtils {
    public static void NavigateToBookScreen(Activity activity,Books book)
    {
        Intent intent=new Intent(activity, BookScreen.class);
        intent.putExtra(NavConstants.BookKey,book);
        activity.startActivity(intent);
    }
    public static void NavigateToHouseScreen(Activity activity,Houses houses)
    {
        Intent intent=new Intent(activity, HouseScreen.class);
        intent.putExtra(NavConstants.HouseKey,houses);
        activity.startActivity(intent);
    }
    public static void NavigateToCharactersScreen(Activity activity,Characters character)
    {
        Intent intent=new Intent(activity, CharacterScreen.class);
        intent.putExtra(NavConstants.CharacterKey,character);
        activity.startActivity(intent);
    }
}
