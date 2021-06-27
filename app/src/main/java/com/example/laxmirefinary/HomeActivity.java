package com.example.laxmirefinary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavapp.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeActivity extends AppCompatActivity {

    private static final String SILVERURL = "https://www.moneycontrol.com/commodity/silver-price.html";
    private static final String GOLDURL = "https://www.moneycontrol.com/commodity/gold-price.html";
    private Long goldMcx = null;
    private Long goldSolapur = null;
    private Long silverMcx = null;
    private Long silverSolapur = null;
    private Long silverMumbai=null;
    private Long silverKolhapur = null;
    private Long silverHydrabad = null;
    private String upperGoldSolapur=null;
    Animation blink_anim;

    String goldSolapurChange=null;

    //    private Long currentRate;
//    private FirebaseRecyclerOptions<Metals> Metals;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;
//    ProgressDialog progressDialog;
    TextView goldMcxTextView;
    TextView goldSolapurTextView;
    TextView upperGoldSolapurTextView;
    TextView silverMcxTextView;
    TextView silverSolapurTextView;
    TextView upperSilverSolapurTextView;
    TextView silverHydrabadTextView;
    TextView silverMumbaiTextView;
    TextView silverKolhapurTextView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    Handler handler = new Handler();
    Runnable runnable;



    //------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //----Declaration and initilization------
        goldMcxTextView =  findViewById(R.id.goldmcx);

//                        blink_anim = AnimationUtils.loadAnimation(getContext(),R.anim.blink);
//        goldMcxTextView.startAnimation(blink_anim);

        goldSolapurTextView =  findViewById(R.id.goldsolapur);
        upperGoldSolapurTextView =  findViewById(R.id.uppergoldsolapur);

        silverMcxTextView =  findViewById(R.id.silvermcx);
        silverSolapurTextView =  findViewById(R.id.silversoplapur);

        upperSilverSolapurTextView = findViewById(R.id.uppersilversoplapur);
        silverHydrabadTextView = findViewById(R.id.silverhydrabad);
        silverMumbaiTextView =  findViewById(R.id.silvermumbai);
        silverKolhapurTextView =  findViewById(R.id.silverkolhapur);

        //----End Declaration and initilization------

        //-----Fetch values


/*        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, 10000);
                *//*Toast.makeText(HomeActivity.this, "This method is run every 10 seconds",
                        Toast.LENGTH_SHORT).show();*//*

        try{



            goldMcx = Math.round(getGoldData());
            goldSolapur = Math.round(goldMcx + (goldMcx * 0.03));


            silverMcx = Math.round(getSilverData());
            silverSolapur = Math.round(silverMcx + (silverMcx * 0.03) + 100);
            silverMumbai = silverSolapur - 500;
            silverKolhapur = silverSolapur - 1100;
            silverHydrabad = silverSolapur;
        }catch(Exception ex) {
            ex.printStackTrace();
        }


        //-----End Fetch values


        //----Set values

        if (goldMcx != null) {
            goldMcxTextView.setText("Rs " + goldMcx.toString());
            goldSolapurTextView.setText("Rs " + goldSolapur.toString());
            upperGoldSolapur = "Gold" + "\n" + goldSolapur.toString() + "\n" + "13.15(0.75%)";
            upperGoldSolapurTextView.setText(upperGoldSolapur);
        } else {
            goldMcxTextView.setText("No Value");
        }
        if (silverMcx != null) {
            String upperSilverSolapur = "Silver" + "\n" + silverSolapur.toString() + "\n" + "0.103(0.4%)";
            upperSilverSolapurTextView.setText(upperSilverSolapur);
            silverMcxTextView.setText("Rs " + silverMcx.toString());
            silverHydrabadTextView.setText("Rs " + silverHydrabad.toString());
            silverMumbaiTextView.setText("Rs " + silverMumbai.toString());
            silverKolhapurTextView.setText("Rs " + silverKolhapur.toString());
            silverSolapurTextView.setText("Rs " + silverSolapur.toString());

        } else {
            silverMcxTextView.setText("No Value");
        }



            }
        }, 10000);*/
        //----End Set values

        //-----------------------------DataBase Start----------------------------------------------------

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Query postsQuery = FirebaseDatabase.getInstance().getReference();

        FirebaseRecyclerOptions<Metals> options = new FirebaseRecyclerOptions.Builder<Metals>()
                .setQuery(postsQuery, Metals.class)
                .build();


        //-----------------------------DataBase Start----------------------------------------------------

        try {


            final int intervalTime = 10000; // 10 sec

            Content content = new Content();
            content.execute();


        }catch (Exception ex){
            ex.printStackTrace();
        }



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        break;
                    case R.id.navigation_connect:
                        Intent a = new Intent(HomeActivity.this,ConnectActivity.class);
                        startActivity(a);
                        overridePendingTransition(0, 0);
                        break;

                }
                return false;
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Metals");

    }






    @SuppressLint("StaticFieldLeak")
    private class Content extends AsyncTask<Void, Integer, String> {

        public Content() {
        }

        @Override
        public void onPreExecute() {
            super.onPreExecute();
            //            progressDialog = new ProgressDialog(getActivity());
            //            progressDialog.setMessage("Loading , Please wait...");
            //            progressDialog.setIndeterminate(true);
            //            progressDialog.setCancelable(false);
            //            progressDialog.setCanceledOnTouchOutside(false);
            //            progressDialog.show();


        }


        @Override
        protected String doInBackground(Void... voids) {




            try{



                goldMcx = Math.round(getGoldData());
                goldSolapur = Math.round(goldMcx + (goldMcx * 0.03));


                silverMcx = Math.round(getSilverData());
                silverSolapur = Math.round(silverMcx + (silverMcx * 0.03) + 100);
                silverMumbai = silverSolapur - 500;
                silverKolhapur = silverSolapur - 1100;
                silverHydrabad = silverSolapur;
            }catch(Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String aVoid) {


            super.onPostExecute(aVoid);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @SuppressLint("SetTextI18n")
                @Override
                public void run() {
                    try{

                        goldMcx = Math.round(getGoldData());
                        goldSolapur = Math.round(goldMcx + (goldMcx * 0.03));


                        silverMcx = Math.round(getSilverData());
                        silverSolapur = Math.round(silverMcx + (silverMcx * 0.03) + 100);
                        silverMumbai = silverSolapur - 500;
                        silverKolhapur = silverSolapur - 1100;
                        silverHydrabad = silverSolapur;

                        goldMcxTextView =  findViewById(R.id.goldmcx);

                        blink_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                        goldMcxTextView.startAnimation(blink_anim);

                        goldSolapurTextView =  findViewById(R.id.goldsolapur);
                        upperGoldSolapurTextView =  findViewById(R.id.uppergoldsolapur);

                        silverMcxTextView =  findViewById(R.id.silvermcx);
                        silverSolapurTextView =  findViewById(R.id.silversoplapur);

                        upperSilverSolapurTextView = findViewById(R.id.uppersilversoplapur);
                        silverHydrabadTextView = findViewById(R.id.silverhydrabad);
                        silverMumbaiTextView =  findViewById(R.id.silvermumbai);
                        silverKolhapurTextView =  findViewById(R.id.silverkolhapur);

                        if (goldMcx != null) {
                            goldMcxTextView.setText("Rs " + goldMcx.toString());
                            goldSolapurTextView.setText("Rs " + goldSolapur.toString());
                            upperGoldSolapur = "Gold" + "\n" + goldSolapur.toString() + "\n" + "13.15(0.75%)";
                            upperGoldSolapurTextView.setText(upperGoldSolapur);
                            System.out.println("Gold set sucessfully");
                        } else {
                            goldMcxTextView.setText("No Value");
                        }
                        if (silverMcx != null) {
                            String upperSilverSolapur = "Silver" + "\n" + silverSolapur.toString() + "\n" + "0.103(0.4%)";
                            upperSilverSolapurTextView.setText(upperSilverSolapur);
                            silverMcxTextView.setText("Rs " + silverMcx.toString());
                            silverHydrabadTextView.setText("Rs " + silverHydrabad.toString());
                            silverMumbaiTextView.setText("Rs " + silverMumbai.toString());
                            silverKolhapurTextView.setText("Rs " + silverKolhapur.toString());
                            silverSolapurTextView.setText("Rs " + silverSolapur.toString());

                            System.out.println("Silver  set sucessfully");

                        } else {
                            silverMcxTextView.setText("No Value");
                        }

                        handler.postDelayed(this,10000);
                    }catch(Exception ex) {

                        ex.printStackTrace();
                    }
                }
            }, 5000);





        }



    }

    private Double getGoldData() {


        Double price = null;
        Document doc;
        try {
            doc = Jsoup.connect(GOLDURL).get();

            Elements tables = doc.getElementsByClass("ML7 MR7 PT5 PB5 brdb");
            Element table1 = tables.get(0);




            Elements cell = table1.select("td");

            Element td = cell.get(1);


            String tdr = td.text();

            System.out.println(tdr);


            Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher;
            matcher = regex.matcher(tdr);
            while (matcher.find()) {
                price = Double.parseDouble(Objects.requireNonNull(matcher.group(1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }

    private Double getSilverData() {


        Double price = null;
        Document doc ;
        try {
            doc = Jsoup.connect(SILVERURL).get();



            Elements tables = doc.getElementsByClass("ML7 MR7 PT5 PB5 brdb");
            Element table1 = tables.get(0);




            Elements cell = table1.select("td");

            Element td = cell.get(1);


            String tdr = td.text();
            System.out.println(tdr);


            Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher = regex.matcher(tdr);
            while (matcher.find()) {
                price = Double.parseDouble(Objects.requireNonNull(matcher.group(1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return price;
    }

/*    private boolean isDeviceOnline() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }*/

/*    private boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }*/



}