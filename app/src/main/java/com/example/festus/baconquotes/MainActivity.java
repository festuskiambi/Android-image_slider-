package com.example.festus.baconquotes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;


public class MainActivity extends ActionBarActivity implements BaseSliderView.OnSliderClickListener {
    private SliderLayout myslider;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myslider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Bacon",R.drawable.baconimg1);
        file_maps.put("More Bacon",R.drawable.baconimg2);
        file_maps.put("My Favorite",R.drawable.images);
        file_maps.put("Best Of All", R.drawable.baconimg3);

        for(String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.getBundle()
                    .putString("extra", name);

            myslider.addSlider(textSliderView);
        }
        myslider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        myslider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        myslider.setCustomAnimation(new DescriptionAnimation());
        myslider.setDuration(4000);

        String[] bacnQuotes = {"You worry too much. Eat some bacon...what? No,",
                "idea if it\\'ll make you feel better, I just made too much bacon."
        ,"And hey, bacon made everything better","Even apocalypse looks less dire " ,
                "when viewed over a plate of bacon.","Bacon, The source of all happiness",
                "We had a bacon love—even when it was bad, it was good. And crispy."};
        ListAdapter storyListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, bacnQuotes);

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, bacnQuotes));
        lv.setTextFilterEnabled(true);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {

    }
}
