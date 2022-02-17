package com.example.LaxmiRefinary;

import static android.view.View.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavapp.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

//    private static final String SILVERURL = "https://www.moneycontrol.com/commodity/silver-price.html";
//    private static final String GOLDURL = "https://www.moneycontrol.com/commodity/gold-price.html";

    final String GOLDUSDURL="https://www.investing.com/commodities/gold";

    final String SILVERUSDURL="https://www.investing.com/commodities/silver";

    final String USDINRURL="https://in.investing.com/currencies/usd-inr";

    final String GOLDINRURL="https://in.investing.com/commodities/refined-gold?cid=49776";

    final String SILVERINRURL="https://in.investing.com/commodities/silver?cid=49791";

    private Long goldMcx = null;
    private Long goldSolapur = null;
    private Long silverMcx = null;
//    private Long silverSolapur = null;
    private Long silverMumbai=null;
    private Long silverKolhapur = null;
    private Long silverHydrabad = null;
    private Long goldMumbai95 = null;
    private Long goldMumbai99 = null;
    private Long goldSolapur95 = null;
    private Long silverSolapur9 = null;
    private Long silverSolapur99 = null;


    private String upperGoldUsdString=null;
    private Double upperGoldUsd=null;
    private Double upperSilverUsd=null;
    private Double upperUsdInr=null;

    private String upperSilverUsdString=null;
    private String upperUsdInrString=null;

    Animation blink_anim;

    String goldSolapurChange=null;

//        private Long currentRate;
//    ProgressDialog progressDialog;
    TextView goldMcxTextView ;
    TextView goldSolapurTextView;
    TextView goldMumbai99TextView;
    TextView goldMumbai95TextView;
    TextView goldSolapur95TextView;

    TextView silverMcxTextView;
//    TextView silverSolapurTextView;
    TextView silverHydrabadTextView;
    TextView silverMumbaiTextView;
    TextView silverKolhapurTextView;

    TextView silverSolapur99TextView;
    TextView silverSolapur9TextView;

    TextView upperGoldUsdTextView;
    TextView upperSilverUsdTextView;
    TextView upperUsdInrTextView;

    TextView liveDot;


    private FirebaseRecyclerOptions<Metals> Metals;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

//    Metals metals;

    Long goldSolapurDb = null;
    Long goldMumbai95Db = null;
    Long goldMumbai99Db = null;
    Long goldSolapur95Db = null;

//    Long silverSolapurDb = null;
    Long silverMumbaiDb = null;
    Long silverHydrabadDb = null;
    Long silverKolhapurDb = null;
    Long silverSolapur9Db = null;
    Long silverSolapur99Db = null;

    String goldSolapurOperatorDb = null;
    String goldMumbai95OperatorDb = null;
    String goldMumbai99OperatorDb = null;
    String goldSolapur95OperatorDb = null;

//    String silverSolapurOperatorDb = null;
    String silverMumbaiOperatorDb = null;
    String silverHydrabadOperatorDb = null;
    String silverKolhapurOperatorDb = null;
    String silverSolapur9OperatorDb = null;

    String silverSolapur99OperatorDb = null;



    Handler handler = new Handler();
    Runnable runnable;

    private Timer mTimer;
    private TimerTask mTimerTask;

    //------------------------------------
    @SuppressLint("NonConstantResourceId")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //----Declaration and initilization------
//        goldMcxTextView =  findViewById(R.id.goldmcx);

//                        blink_anim = AnimationUtils.loadAnimation(getContext(),R.anim.blink);
//        goldMcxTextView.startAnimation(blink_anim);

        goldMumbai99TextView =  findViewById(R.id.goldmumbai99);
        goldMumbai95TextView =  findViewById(R.id.goldmumbai95);
        goldSolapur95TextView =  findViewById(R.id.goldsolapur95);

        silverSolapur9TextView =  findViewById(R.id.silversoplapur9);
        silverSolapur99TextView =  findViewById(R.id.silversoplapur99);

        goldSolapurTextView =  findViewById(R.id.goldsolapur);
        upperGoldUsdTextView =  findViewById(R.id.uppergoldusd);

        silverMcxTextView =  findViewById(R.id.silvermcx);
//        silverSolapurTextView =  findViewById(R.id.silversoplapur);

        upperSilverUsdTextView = findViewById(R.id.uppersilverusd);
        silverHydrabadTextView = findViewById(R.id.silverhydrabad);
        silverMumbaiTextView =  findViewById(R.id.silvermumbai);
        silverKolhapurTextView =  findViewById(R.id.silverkolhapur);

        upperUsdInrTextView=  findViewById(R.id.upperusdinr);
        upperGoldUsdTextView=findViewById(R.id.uppergoldusd);
        upperSilverUsdTextView=findViewById(R.id.uppersilverusd);

        liveDot = findViewById(R.id.livedot);
        //----End Declaration and initilization------





        blink_anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        liveDot.startAnimation(blink_anim);
        //-----------------------------DataBase Start----------------------------------------------------
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase.getReference("prices");






        //-----------------------------DataBase End----------------------------------------------------

        try {


            mTimer = new Timer();
            mTimerTask = new TimerTask() {
                @Override
                public void run() {
            Content content = new Content();
            content.execute();  }
            };
            mTimer.schedule(mTimerTask, // Task to be executed multiple times
                    0, // How long to delay in Milliseconds
                    10000); // How long between iterations in Milliseconds


        }catch (Exception ex){
            ex.printStackTrace();
        }



        BottomNavigationView navigation = findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    break;
                case R.id.navigation_ads:
                    Intent ads = new Intent(HomeActivity.this,Ads.class);
                    startActivity(ads);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.navigation_connect:
                    Intent connect = new Intent(HomeActivity.this,ConnectActivity.class);
                    startActivity(connect);
                    overridePendingTransition(0, 0);
                    break;

            }
            return false;
        });

    }

    private void getDataFromDatabase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Map<String, Object> map;
                map = (Map<String, Object>) snapshot.getValue();


        try {
                for (String key : Objects.requireNonNull(map).keySet()) {

                    switch (key) {
                        case "goldSolapur":
                            goldSolapurDb = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "goldMumbai95":
                            goldMumbai95Db = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "goldMumbai99":
                            goldMumbai99Db = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "goldSolapur95":
                            goldSolapur95Db = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
//                        case "silverSolapur" : silverSolapurDb= Long.valueOf(map.get(key).toString());
//                            break;
                        case "silverMumbai":
                            silverMumbaiDb = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "silverHydrabad":
                            silverHydrabadDb = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "silverKolhapur":
                            silverKolhapurDb = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "silverSolapur9":
                            silverSolapur9Db = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "silverSolapur99":
                            silverSolapur99Db = Long.valueOf(Objects.requireNonNull(map.get(key)).toString());
                            break;
                        case "goldMumbai95Operator":
                            goldMumbai95OperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        case "goldMumbai99Operator":
                            goldMumbai99OperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        case "goldSolapur95Operator":
                            goldSolapur95OperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        case "goldSolapurOperator":
                            goldSolapurOperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        case "silverSolapur9Operator":
                            silverSolapur9OperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        case "silverSolapur99Operator":
                            silverSolapur99OperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
//                        case "silverSolapurOperator" : silverSolapurOperatorDb=map.get(key).toString();
//                            break;
                        case "silverMumbaiOperator":
                            silverMumbaiOperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        case "silverHydrabadOperator":
                            silverHydrabadOperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        case "silverKolhapurOperator":
                            silverKolhapurOperatorDb = Objects.requireNonNull(map.get(key)).toString();
                            break;
                        default:
                            break;
                    }

                }

                }catch (Exception ex){
                ex.printStackTrace();
        }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(HomeActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }







    @SuppressLint("StaticFieldLeak")
    private class Content extends AsyncTask<Void, Integer, String> {


        @Override
        public void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected String doInBackground(Void... voids) {

            try{

                getDataFromDatabase();

                goldMcx = Math.round(getGoldData());
                silverMcx = Math.round(getSilverData());
                upperUsdInr=getUsdInrData();
                upperSilverUsd=getSilverUsdData();
                upperGoldUsd=getGoldUsdData();


                if(goldSolapurOperatorDb.equals("add")) {
                    goldSolapur = Math.round(goldMcx + (goldMcx * 0.03) + goldSolapurDb);
                }
                else{
                    goldSolapur = Math.round(goldMcx + (goldMcx * 0.03) - goldSolapurDb);
                }



                if(silverMumbaiOperatorDb.equals("add"))
                {
                     silverMumbai =  Math.round(silverMcx + (silverMcx * 0.03) + silverMumbaiDb);
                }
                else{
                    silverMumbai = Math.round(silverMcx + (silverMcx * 0.03)  - silverMumbaiDb);
                }

                if(silverKolhapurOperatorDb.equals("add"))
                {
                     silverKolhapur = Math.round(silverMcx + (silverMcx * 0.03)  + silverKolhapurDb);  }
                else{
                    silverKolhapur = Math.round(silverMcx + (silverMcx * 0.03)  - silverKolhapurDb);
                    }

                if(silverHydrabadOperatorDb.equals("add"))
                {
                    silverHydrabad = Math.round(silverMcx + (silverMcx * 0.03)  + silverHydrabadDb);
                }
                    else{
                    silverHydrabad = Math.round(silverMcx + (silverMcx * 0.03)  - silverHydrabadDb);
                }
                if(goldMumbai95OperatorDb.equals("add"))
                {
                    goldMumbai95 = Math.round(goldMcx + (goldMcx * 0.03)  + goldMumbai95Db);
                }
                else{
                    goldMumbai95 = Math.round(goldMcx + (goldMcx * 0.03)  - goldMumbai95Db);
                }

                if(goldMumbai99OperatorDb.equals("add"))
                {
                    goldMumbai99 = Math.round(goldMcx + (goldMcx * 0.03)  + goldMumbai99Db);
                }
                else{
                    goldMumbai99 = Math.round(goldMcx + (goldMcx * 0.03)  - goldMumbai99Db);
                }
                if(goldSolapur95OperatorDb.equals("add"))
                {
                    goldSolapur95 = Math.round(goldMcx + (goldMcx * 0.03)  + goldSolapur95Db);
                }
                else{
                    goldSolapur95 = Math.round(goldMcx + (goldMcx * 0.03)  - goldSolapur95Db);
                }
                if(silverSolapur9OperatorDb.equals("add"))
                {
                    silverSolapur9 = Math.round(silverMcx + (silverMcx * 0.03)  + silverSolapur9Db);
                }
                else{
                    silverSolapur9 = Math.round(silverMcx + (silverMcx * 0.03)  - silverSolapur9Db);
                }
                if(silverSolapur99OperatorDb.equals("add"))
                {
                    silverSolapur99 = Math.round(silverMcx + (silverMcx * 0.03)  + silverSolapur99Db);
                }
                else{
                    silverSolapur99 = Math.round(silverMcx + (silverMcx * 0.03)  - silverSolapur99Db);
                }

            }catch(Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String aVoid) {


            super.onPostExecute(aVoid);

                    try{

                        goldMcxTextView =  findViewById(R.id.goldmcx);


                        goldMumbai99TextView =  findViewById(R.id.goldmumbai99);
                        goldMumbai95TextView =  findViewById(R.id.goldmumbai95);
                        goldSolapur95TextView =  findViewById(R.id.goldsolapur95);


                        silverSolapur9TextView =  findViewById(R.id.silversoplapur9);
                        silverSolapur99TextView =  findViewById(R.id.silversoplapur99);

                        goldSolapurTextView =  findViewById(R.id.goldsolapur);
                        upperGoldUsdTextView =  findViewById(R.id.uppergoldusd);

                        silverMcxTextView =  findViewById(R.id.silvermcx);

                        upperSilverUsdTextView = findViewById(R.id.uppersilverusd);
                        silverHydrabadTextView = findViewById(R.id.silverhydrabad);
                        silverMumbaiTextView =  findViewById(R.id.silvermumbai);
                        silverKolhapurTextView =  findViewById(R.id.silverkolhapur);


                        upperUsdInrTextView=  findViewById(R.id.upperusdinr);
                        upperGoldUsdTextView=findViewById(R.id.uppergoldusd);
                        upperSilverUsdTextView=findViewById(R.id.uppersilverusd);

                        if (upperGoldUsd != null) {
                            upperGoldUsdString = "Gold" + "\n" + upperGoldUsd + "";
                            upperGoldUsdTextView.setText(upperGoldUsdString);
                        } else {
                            upperGoldUsdTextView.setText("No Value");
                        }

                        if (upperSilverUsd!= null) {
                            upperSilverUsdString = "Silver" + "\n" + upperSilverUsd + "";
                            upperSilverUsdTextView.setText(upperSilverUsdString);
                        } else {
                            upperGoldUsdTextView.setText("No Value");
                        }

                        if (upperUsdInr!= null) {
                            upperUsdInrString = "USD" + "\n" + upperUsdInr + "";
                            upperUsdInrTextView.setText(upperUsdInrString);
                        } else {
                            upperUsdInrTextView.setText("No Value");
                        }

                        if (goldMcx != null) {
                            goldMcxTextView.setText("Rs " + goldMcx);
                            goldSolapurTextView.setText("Rs " + goldSolapur);

                            goldMumbai99TextView.setText("Rs " + goldMumbai99);
                            goldMumbai95TextView.setText("Rs " + goldMumbai95);
                            goldSolapur95TextView.setText("Rs " + goldSolapur95);


                        } else {
                            goldMcxTextView.setText("No Value");
                        }
                        if (silverMcx != null) {
                            silverMcxTextView.setText("Rs " + silverMcx);
                            silverHydrabadTextView.setText("Rs " + silverHydrabad);
                            silverMumbaiTextView.setText("Rs " + silverMumbai);
                            silverKolhapurTextView.setText("Rs " + silverKolhapur);


                            silverSolapur9TextView.setText("Rs " + silverSolapur9);
                            silverSolapur99TextView.setText("Rs " + silverSolapur99);



                        } else {
                            silverMcxTextView.setText("No Value");
                        }

                    }catch(Exception ex) {

                        ex.printStackTrace();
                    }





        }



    }
/*
money control code
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

//            System.out.println(tdr);


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
//            System.out.println(tdr);


            Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher = regex.matcher(tdr);
            while (matcher.find()) {
                price = Double.parseDouble(Objects.requireNonNull(matcher.group(1)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return price;
    }*/


    private Double getGoldData() {


        Double price = null;
        Document docGoldInr;
        try {
            docGoldInr = Jsoup.connect(GOLDINRURL).get();

            Elements tablesDocGoldInr=docGoldInr.getElementsByClass("last-price-value js-streamable-element"); //--for goldINR and silverInr and usdInr
            Element tableDocGoldInr=tablesDocGoldInr.get(0);
              String tdr = tableDocGoldInr.text();

//            System.out.println(tdr);
            tdr=  tdr.replace(",","");

            price=Double.valueOf(tdr);
//            System.out.println(tdr);

        /*    Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher;
            matcher = regex.matcher(tdr);
            while (matcher.find()) {
                price = Double.parseDouble(Objects.requireNonNull(matcher.group(1)));
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }

    private Double getSilverData() {


        Double price = null;
        Document docSilverInr ;
        try {
            docSilverInr = Jsoup.connect(SILVERINRURL).get();



            Elements tablesDocSilverInr=docSilverInr.getElementsByClass("last-price-value js-streamable-element"); //--for goldINR and silverInr and usdInr
            Element tableDocSilverInr=tablesDocSilverInr.get(0);

            String tdr = tableDocSilverInr.text();
//            System.out.println(tdr);

            tdr=  tdr.replace(",","");

            price=Double.valueOf(tdr);
        /*    System.out.println(tdr);
            Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher = regex.matcher(tdr);
            while (matcher.find()) {
                price = Double.parseDouble(Objects.requireNonNull(matcher.group(1)));
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }

        return price;
    }

    private Double getGoldUsdData() {


        Double price = null;
        Document docGoldUsdUrl;
        try {
            docGoldUsdUrl = Jsoup.connect(GOLDUSDURL).get();

            Elements span=docGoldUsdUrl.select("span.text-2xl");

            System.out.println(span.text());

            String tdr = span.text();

            tdr=  tdr.replace(",","");

            price=Double.valueOf(tdr);

//            System.out.println(tdr);


            /*Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher;
            matcher = regex.matcher(tdr);
            while (matcher.find()) {
                price = Double.parseDouble(Objects.requireNonNull(matcher.group(1)));
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }

    private Double getSilverUsdData() {


        Double price = null;
        Document docSilverUsdUrl ;
        try {
            docSilverUsdUrl = Jsoup.connect(SILVERUSDURL).get();

            Elements span=docSilverUsdUrl.select("span.text-2xl");

            System.out.println(span.text());


            price=Double.valueOf(span.text());

            System.out.println(price);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return price;

    }    private Double getUsdInrData() {


        Double price = null;
        Document docUsdInr;
        try {
            docUsdInr = Jsoup.connect(USDINRURL).get();

            Elements tablesDocUsdInr=docUsdInr.getElementsByClass("last-price-value js-streamable-element"); //--for goldINR and silverInr and usdInr
            Element tableDocUsdInr=tablesDocUsdInr.get(0);

            String tdr = tableDocUsdInr.text();

//            System.out.println(tdr);

            tdr=  tdr.replace(",","");

            price=Double.valueOf(tdr);
           /* Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
            Matcher matcher;
            matcher = regex.matcher(tdr);
            while (matcher.find()) {
                price = Double.parseDouble(Objects.requireNonNull(matcher.group(1)));
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return price;
    }





}