package com.example.laxmirefinary;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bottomnavapp.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
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
//        Timer myTimer = new Timer();

        Content content = new Content();
        content.execute(1000);
//        myTimer.schedule(content.execute(1000), 3000, 1500);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @SuppressLint("StaticFieldLeak")
    private class Content extends AsyncTask<Integer, String, Boolean> {



        @Override
        protected void onPreExecute() {
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

            goldMcx = Math.round(getGoldData());
            goldSolapur = Math.round(goldMcx + (goldMcx*0.03));


            silverMcx = Math.round(getSilverData());
            silverSolapur = Math.round(silverMcx + (silverMcx*0.03)+100);
            silverMumbai=silverSolapur-500;
            silverKolhapur = silverSolapur - 1100;
            silverHydrabad = silverSolapur;

            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Boolean aVoid) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(this, 5000);
                }
            }, 3000);


             goldMcxTextView =  getView().findViewById(R.id.goldmcx);
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
                String upperGoldSolapur = "Gold" + "\n" + goldSolapur.toString() + "\n" + "13.15(0.75%)";
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


    }


    private Double getGoldData() {


        Double price = null;
        Document doc = null;
        try {
            doc = Jsoup.connect(HomeFragment.GOLDURL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // parseItems.add(new ParseItem(d));


        Elements tables = doc.getElementsByClass("ML7 MR7 PT5 PB5 brdb");
        Element table1 = tables.get(0);




        Elements cell = table1.select("td");

        Element td = cell.get(1);


        String tdr = td.text();


        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(tdr);
        while (matcher.find()) {
            price = Double.parseDouble(matcher.group(1));
        }
        return price;
    }

    private Double getSilverData() {


        Double price = null;
        Document doc = null;
        try {
            doc = Jsoup.connect(HomeFragment.SILVERURL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Elements tables = doc.getElementsByClass("ML7 MR7 PT5 PB5 brdb");
        Element table1 = tables.get(0);




        Elements cell = table1.select("td");

        Element td = cell.get(1);


        String tdr = td.text();
        System.out.println(tdr);


        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(tdr);
        while (matcher.find()) {
            price = Double.parseDouble(matcher.group(1));
        }
        return price;
    }


}