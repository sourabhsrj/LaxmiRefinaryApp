package com.example.LaxmiRefinary;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottomnavapp.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
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


public class HomeFragment extends Fragment {

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

    public HomeFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        new Bundle();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Executors.newSingleThreadExecutor().execute(() -> {
//
//            Handler mainHandler = new Handler(Looper.getMainLooper());
//
//            //sync calculations
//
//            mainHandler.post(() -> {
//                //Update UI
//            });
//
//            //other sync calcs.
//
//            mainHandler.post(() -> {
//                //Update UI
//            });
//
//        });



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
            content.execute(intervalTime);


        }catch (Exception ex){
            ex.printStackTrace();
        }


    }


    @Override
    public void onStart() {
        super.onStart();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Metals");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @SuppressLint("StaticFieldLeak")
    private class Content extends AsyncTask<Integer, String, Boolean> {




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

        protected Boolean doInBackground(Integer... integers) {



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
        protected void onPostExecute(Boolean aVoid) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @SuppressLint("SetTextI18n")
                @Override
                public void run() {
                    try{

//                        goldMcx = Math.round(getGoldData());
//                        goldSolapur = Math.round(goldMcx + (goldMcx * 0.03));
//
//
//                        silverMcx = Math.round(getSilverData());
//                        silverSolapur = Math.round(silverMcx + (silverMcx * 0.03) + 100);
//                        silverMumbai = silverSolapur - 500;
//                        silverKolhapur = silverSolapur - 1100;
//                        silverHydrabad = silverSolapur;

                        goldMcxTextView =  getView().findViewById(R.id.goldmcx);

                        blink_anim = AnimationUtils.loadAnimation(getContext(),R.anim.blink);
                        goldMcxTextView.startAnimation(blink_anim);

                        goldSolapurTextView =  getView().findViewById(R.id.goldsolapur);
                        upperGoldSolapurTextView =  getView().findViewById(R.id.uppergoldsolapur);

                        silverMcxTextView =  getView().findViewById(R.id.silvermcx);
                        silverSolapurTextView =  getView().findViewById(R.id.silversoplapur);

                        upperSilverSolapurTextView = getView().findViewById(R.id.uppersilversoplapur);
                        silverHydrabadTextView = getView().findViewById(R.id.silverhydrabad);
                        silverMumbaiTextView =  getView().findViewById(R.id.silvermumbai);
                        silverKolhapurTextView =  getView().findViewById(R.id.silverkolhapur);

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


                    handler.postDelayed(this, 3000);
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
            doc = Jsoup.connect(HomeFragment.GOLDURL).get();

        Elements tables = doc.getElementsByClass("ML7 MR7 PT5 PB5 brdb");
        Element table1 = tables.get(0);




        Elements cell = table1.select("td");

        Element td = cell.get(1);


        String tdr = td.text();


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
            doc = Jsoup.connect(HomeFragment.SILVERURL).get();



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