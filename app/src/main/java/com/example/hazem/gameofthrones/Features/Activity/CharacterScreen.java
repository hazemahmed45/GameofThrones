package com.example.hazem.gameofthrones.Features.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.hazem.gameofthrones.Base.Constants.NavConstants;
import com.example.hazem.gameofthrones.Base.GOTapplications;
import com.example.hazem.gameofthrones.Models.Characters;
import com.example.hazem.gameofthrones.R;
import com.example.hazem.gameofthrones.Utils.RequestUtils;
import com.example.hazem.gameofthrones.Utils.StringUtil;
import com.example.hazem.gameofthrones.Utils.ViewUtils;

public class CharacterScreen extends AppCompatActivity {
    Characters character;
    View GenderView,CultureView,BornView,DiedView,TitlesView,AliasesView,FatherView,MotherView,SpouseView,AllegiancesView,BooksView,PovBooksView,TvSeriesView,PlayedByView;
    TextView Gender,Culture,Born,Died,Titles,Aliases,Father,Mother,Spouse,Allegiances,Books,PovBooks,TvSeries,PlayedBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_screen_activity);
        if(getIntent()!=null)
        {
            character= (Characters) getIntent().getSerializableExtra(NavConstants.CharacterKey);
        }
        SettingIDs();
        SettingData();
    }
    void SettingIDs()
    {
        GenderView=findViewById(R.id.charachter_gender);
        CultureView=findViewById(R.id.charachter_culture);
        BornView=findViewById(R.id.charachter_born);
        DiedView=findViewById(R.id.charachter_died);
        TitlesView=findViewById(R.id.charachter_titles);
        AliasesView=findViewById(R.id.charachter_aliases);
        FatherView=findViewById(R.id.charachter_father);
        MotherView=findViewById(R.id.charachter_mother);
        SpouseView=findViewById(R.id.charachter_spouse);
        AllegiancesView=findViewById(R.id.charachter_allegiances);
        BooksView=findViewById(R.id.charachter_books);
        PovBooksView=findViewById(R.id.charachter_povbooks);
        TvSeriesView=findViewById(R.id.charachter_tvseries);
        PlayedByView=findViewById(R.id.charachter_playedby);

        Gender= (TextView) GenderView.findViewById(R.id.data);
        Culture= (TextView) CultureView.findViewById(R.id.data);
        Born= (TextView) BooksView.findViewById(R.id.data);
        Died= (TextView) DiedView.findViewById(R.id.data);
        Titles= (TextView) TitlesView.findViewById(R.id.data);
        Aliases= (TextView) AliasesView.findViewById(R.id.data);
        Father= (TextView) FatherView.findViewById(R.id.data);
        Mother= (TextView) MotherView.findViewById(R.id.data);
        Spouse= (TextView) SpouseView.findViewById(R.id.data);
        Allegiances= (TextView) AllegiancesView.findViewById(R.id.data);
        Books= (TextView) BooksView.findViewById(R.id.data);
        PovBooks= (TextView) PovBooksView.findViewById(R.id.data);
        TvSeries= (TextView) TvSeriesView.findViewById(R.id.data);
        PlayedBy= (TextView) PlayedByView.findViewById(R.id.data);

        ((TextView) GenderView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.gender));
        ((TextView) CultureView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.culture));
        ((TextView) BornView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.born));
        ((TextView) DiedView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.died));
        ((TextView) TitlesView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.charactertitles));
        ((TextView) AliasesView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.aliases));
        ((TextView) FatherView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.father));
        ((TextView) MotherView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.mother));
        ((TextView) SpouseView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.spouse));
        ((TextView) AllegiancesView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.allegiances));
        ((TextView) PovBooksView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.povbooks));
        ((TextView) BooksView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.books));
        ((TextView) TvSeriesView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.tvseries));
        ((TextView) PlayedByView.findViewById(R.id.header)).setText(StringUtil.getStringRes(R.string.playedby));
    }
    void SettingData()
    {
        RequestQueue queue= GOTapplications.getmInstance().getQueue(this);
        ViewUtils.CheckView(character.getGender(),GenderView,Gender);
        ViewUtils.CheckView(character.getBorn(),BornView,Born);
        ViewUtils.CheckView(character.getCulture(),CultureView,Culture);
        ViewUtils.CheckView(character.getDied(),DiedView,Died);
        ViewUtils.CheckView(ViewUtils.getStringFromList(character.getTitles()),TitlesView,Titles);
        ViewUtils.CheckView(ViewUtils.getStringFromList(character.getAliases()),AliasesView,Aliases);
        ViewUtils.CheckView(ViewUtils.getStringFromList(character.getPlayedBy()),PlayedByView,PlayedBy);
        ViewUtils.CheckView(ViewUtils.getStringFromList(character.getTvSeries()),TvSeriesView,TvSeries);
        RequestUtils.RequestCharacter(character.getFather(),FatherView,Father,queue);
        RequestUtils.RequestCharacter( character.getMother(),MotherView,Mother,queue);
        RequestUtils.RequestCharacter( character.getSpouse(),SpouseView,Spouse,queue);
        RequestUtils.RequestHouses(character.getAllegiances(),AllegiancesView,Allegiances,queue);
        RequestUtils.RequestBooks(character.getBooks(),BooksView,Books,queue);
        RequestUtils.RequestBooks(character.getPovBooks(),PovBooksView,PovBooks,queue);




    }

}
