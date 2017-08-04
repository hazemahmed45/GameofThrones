package com.example.hazem.gameofthrones.Features.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.hazem.gameofthrones.Base.Constants.NavConstants;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.Models.Houses;
import com.example.hazem.gameofthrones.R;
import com.example.hazem.gameofthrones.Utils.RequestUtils;
import com.example.hazem.gameofthrones.Utils.StringUtil;
import com.example.hazem.gameofthrones.Utils.ViewUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class HouseScreen extends AppCompatActivity {
    Houses house;
    RequestQueue queue;
    TextView Region,CoatOfArms,CurrentLord,Heir,Seats,Words,Title,DiedOut,Founded,Founder,OverLord,AncestralWeapons,CadetBranches,SwornMembers;
    View RegionView,CoatOfArmsView,CurrentLordView,HeirView,SeatsView,WordsView,TitleView,DiedOutView,FoundedView,FounderView,OverLordView,AncestralWeaponsView,CadetBranchesView,SwornMembersView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_screen_activity);
        if(getIntent()!=null)
        {
            house= (Houses) getIntent().getSerializableExtra(NavConstants.HouseKey);
            getSupportActionBar().setTitle(house.getName());
        }
        settingIDs();
        settingData();
    }
    void settingIDs()
    {
        CoatOfArmsView=  findViewById(R.id.housescreen_coatofarms);
        CurrentLordView= findViewById(R.id.housescreen_currentlord);
        DiedOutView= findViewById(R.id.housescreen_diedout);
        FoundedView=  findViewById(R.id.housescreen_founded);
        FounderView= findViewById(R.id.housescreen_founder);
        HeirView=  findViewById(R.id.housescreen_heir);
        OverLordView=  findViewById(R.id.housescreen_overlord);
        RegionView=  findViewById(R.id.housescreen_region);
        SeatsView= findViewById(R.id.housescreen_seats);
        TitleView=  findViewById(R.id.housescreen_title);
        WordsView=  findViewById(R.id.housescreen_words);
        AncestralWeaponsView=findViewById(R.id.housescreen_ancestral_weapons);
        CadetBranchesView=findViewById(R.id.housescreen_cadet_branches);
        SwornMembersView=findViewById(R.id.housescreen_sworn_members);

        CoatOfArms= (TextView) CoatOfArmsView.findViewById(R.id.data);
        CurrentLord= (TextView) CurrentLordView.findViewById(R.id.data);
        DiedOut= (TextView) DiedOutView.findViewById(R.id.data);
        Founded= (TextView) FoundedView.findViewById(R.id.data);
        Founder= (TextView) FounderView.findViewById(R.id.data);
        Heir= (TextView) HeirView.findViewById(R.id.data);
        OverLord= (TextView) OverLordView.findViewById(R.id.data);
        Region= (TextView) RegionView.findViewById(R.id.data);
        Seats= (TextView) SeatsView.findViewById(R.id.data);
        Title= (TextView) TitleView.findViewById(R.id.data);
        Words= (TextView) WordsView.findViewById(R.id.data);
        AncestralWeapons= (TextView) AncestralWeaponsView.findViewById(R.id.data);
        CadetBranches= (TextView) CadetBranchesView.findViewById(R.id.data);
        SwornMembers= (TextView) SwornMembersView.findViewById(R.id.data);

        ((TextView) CoatOfArmsView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.coatofarms));
        ((TextView) CurrentLordView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.currentlord));
        ((TextView) DiedOutView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.diedout));
        ((TextView) FoundedView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.founded));
        ((TextView) FounderView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.founder));
        ((TextView) HeirView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.heir));
        ((TextView) OverLordView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.overlord));
        ((TextView) RegionView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.region));
        ((TextView) SeatsView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.seats));
        ((TextView) TitleView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.titles));
        ((TextView) WordsView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.words));
        ((TextView) AncestralWeaponsView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.ancestralweapons));
        ((TextView) CadetBranchesView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.cadetbranches));
        ((TextView) SwornMembersView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.swornsembers));
    }
    void settingData()
    {
        queue=GOTapplications.getmInstance().getQueue(HouseScreen.this);
        Houses h=house;
        ViewUtils.CheckView(h.getRegion(),RegionView,Region);
        ViewUtils.CheckView(h.getCoatOfArms(),CoatOfArmsView,CoatOfArms);
        ViewUtils.CheckView(h.getWords(),WordsView,Words);
        ViewUtils.CheckView(h.getCoatOfArms(),CoatOfArmsView,CoatOfArms);
        ViewUtils.CheckView(ViewUtils.getStringFromList(h.getTitles()),TitleView,Title);
        ViewUtils.CheckView(ViewUtils.getStringFromList(h.getSeats()),SeatsView,Seats);
        ViewUtils.CheckView(h.getFounded(),FoundedView,Founded);
        ViewUtils.CheckView(h.getDiedOut(),DiedOutView,DiedOut);
        ViewUtils.CheckView(ViewUtils.getStringFromList(h.getAncestralWeapons()),AncestralWeaponsView,AncestralWeapons);
        RequestUtils.RequestCharacter(h.getCurrentLord(),CurrentLordView,CurrentLord,queue);
        RequestUtils.RequestCharacter(h.getHeir(),HeirView,Heir,queue);
        RequestUtils.RequestCharacter(h.getFounder(),FounderView,Founder,queue);
        RequestUtils.RequestHouse(h.getOverlord(),OverLordView,OverLord,queue);
        RequestUtils.RequestHouses(h.getCadetBranches(),CadetBranchesView,CadetBranches,queue);
        RequestUtils.RequestCharacters(h.getSwornMembers(),SwornMembersView,SwornMembers,queue);

    }

}
