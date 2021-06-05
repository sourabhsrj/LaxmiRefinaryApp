package com.example.laxmirefinary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bottomnavapp.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    private String upperGoldSolapur=null;
    Animation blink_anim;

    private Long currentRate;
    private FirebaseRecyclerOptions<Metals> Metals;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
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



        try {
            //*******************************DataBaseStart*********************************

//            FirebaseRecyclerOptions<model> options =
//            Metals=
//                new FirebaseRecyclerOptions.Builder<Metals>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Metals"), Metals.class)
//                        .build();

            //*******************************DataBaseEnd*********************************



            //-------synck
//            ScheduledExecutorService scheduleTaskExecutor = Executors.newScheduledThreadPool(5);
//
//// This schedule a runnable task every 2 minutes
//            scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
//                public void run() {
//                    goldMcx = Math.round(getGoldData());
//                    goldSolapur = Math.round(goldMcx + (goldMcx * 0.03));
//
//
//                    silverMcx = Math.round(getSilverData());
//                    silverSolapur = Math.round(silverMcx + (silverMcx * 0.03) + 100);
//                    silverMumbai = silverSolapur - 500;
//                    silverKolhapur = silverSolapur - 1100;
//                    silverHydrabad = silverSolapur;
//
//
//                    if (goldMcx != null) {
//                        goldMcxTextView.setText("Rs " + goldMcx.toString());
//                        goldSolapurTextView.setText("Rs " + goldSolapur.toString());
//                        upperGoldSolapur = "Gold" + "\n" + goldSolapur.toString() + "\n" + "13.15(0.75%)";
//                        upperGoldSolapurTextView.setText(upperGoldSolapur);
//                    } else {
//                        goldMcxTextView.setText("No Value");
//                    }
//                    if (silverMcx != null) {
//                        String upperSilverSolapur = "Silver" + "\n" + silverSolapur.toString() + "\n" + "0.103(0.4%)";
//                        upperSilverSolapurTextView.setText(upperSilverSolapur);
//                        silverMcxTextView.setText("Rs " + silverMcx.toString());
//                        silverHydrabadTextView.setText("Rs " + silverHydrabad.toString());
//                        silverMumbaiTextView.setText("Rs " + silverMumbai.toString());
//                        silverKolhapurTextView.setText("Rs " + silverKolhapur.toString());
//                        silverSolapurTextView.setText("Rs " + silverSolapur.toString());
//
//                    } else {
//                        silverMcxTextView.setText("No Value");
//                    }
//
//
//                }
//            }, 0, 2, TimeUnit.MINUTES);
            //------syncend


//        currentRate= Math.round(getGoldData());
//        goldSolapur = Math.round(currentRate + (currentRate*0.03));
//        goldMcxTextView.setText("Rs " + goldMcx.toString());
//        goldSolapurTextView.setText("Rs " + goldSolapur.toString());
//        upperGoldSolapur = "Gold" + "\n" + goldSolapur.toString() + "\n" + "13.15(0.75%)";
//        upperGoldSolapurTextView.setText(upperGoldSolapur);

/*        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    while (!currentThread().isInterrupted()) {
                        Thread.sleep(10000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                currentRate= Math.round(getGoldData());
                                goldMcx = currentRate;


                                if (currentRate!=goldMcx){
                                    goldMcx = currentRate;
                                    goldSolapur = Math.round(goldMcx + (goldMcx*0.03));
                                    goldMcxTextView.setText("Rs " + goldMcx.toString());
                                    goldSolapurTextView.setText("Rs " + goldSolapur.toString());
                                    upperGoldSolapur = "Gold" + "\n" + goldSolapur.toString() + "\n" + "13.15(0.75%)";
                                    upperGoldSolapurTextView.setText(upperGoldSolapur);
                                }
                                // update TextView here!
                            }
                        });
                    }
                } catch (Throwable e) {
                }
            }
        };

        thread.start();*/


            final int intervalTime = 10000; // 10 sec
  /*      Handler handler = new Handler();



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               currentRate= Math.round(getGoldData());
                goldMcx = currentRate;


                if (currentRate!=goldMcx){
                    goldMcx = currentRate;
            goldSolapur = Math.round(goldMcx + (goldMcx*0.03));
                    goldMcxTextView.setText("Rs " + goldMcx.toString());
                goldSolapurTextView.setText("Rs " + goldSolapur.toString());
                 upperGoldSolapur = "Gold" + "\n" + goldSolapur.toString() + "\n" + "13.15(0.75%)";
                upperGoldSolapurTextView.setText(upperGoldSolapur);
                }
            }
        }, intervalTime);*/
//            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
//        blink_anim = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.blink);
//        Timer myTimer = new Timer();

//        blink_anim = AnimationUtils.loadAnimation(getContext(),
//                R.anim.blink);
//        goldMcxTextView.startAnimation(blink_anim);
//        Timer myTimer = new Timer();



//                @SuppressLint("ObjectAnimatorBinding") ObjectAnimator objectAnimator=ObjectAnimator.ofInt(goldMcxTextView,"backgroundColour", Color.GREEN);
//        objectAnimator.setDuration(100);
//        objectAnimator.setEvaluator(new ArgbEvaluator());
//        objectAnimator.setRepeatMode(Animation.REVERSE);
//        objectAnimator.setRepeatCount(Animation.INFINITE);
//        objectAnimator.start();
//            if (isOnline()) {
//                //do whatever you want to do
//            } else {
//                try {
//
//
//                    alertDialog.setTitle("Info");
//                    alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
//                    alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
//                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
////                            finish();
//                            dialog.dismiss();
//                        }
//                    });
//
//                    alertDialog.show();
//                } catch (Exception e) {
////                    Log.d(SyncStateContract.Constants., "Show Dialog: " + e.getMessage());
//                }
//            }


            Content content = new Content();
            content.execute(intervalTime);



//        new Content(getActivity()).execute(10);
//        myTimer.schedule(content.execute(1000), 3000, 1500);


        /*    ExampleAsyncTask task = new ExampleAsyncTask();
            task.execute(100);*/

        }catch (Exception ex){

        }
    }

   /* private class ExampleAsyncTask extends AsyncTask<Integer, Integer, String> {
//        private WeakReference<HomeFragment> activityWeakReference;
////        private TextView goldMcxTextView;
////        TextView goldSolapurTextView;
////        TextView upperGoldSolapurTextView;
////        TextView silverMcxTextView;
////        TextView silverSolapurTextView;
////        TextView upperSilverSolapurTextView;
////        TextView silverHydrabadTextView;
////        TextView silverMumbaiTextView;
////        TextView silverKolhapurTextView;
//
//        ExampleAsyncTask(HomeFragment activity) {
//            activityWeakReference = new WeakReference<MainActivity>(activity);
//        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
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

        }
        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                publishProgress((i * 100) / integers[0]);
                try {
                    goldMcx = Math.round(getGoldData());
                    goldSolapur = Math.round(goldMcx + (goldMcx * 0.03));


                    silverMcx = Math.round(getSilverData());
                    silverSolapur = Math.round(silverMcx + (silverMcx * 0.03) + 100);
                    silverMumbai = silverSolapur - 500;
                    silverKolhapur = silverSolapur - 1100;
                    silverHydrabad = silverSolapur;





                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finished!";
        }
        @Override
        protected void onProgressUpdate(Integer... values) {

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
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
    }
*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);
    }


//    @SuppressLint("StaticFieldLeak")
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

            try {
//                final Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//
//
//
//                    @Override
//                    public void run() {
//                        try{
                goldMcxTextView =  getView().findViewById(R.id.goldmcx);

//        blink_anim = AnimationUtils.loadAnimation(getContext(),R.anim.blink);
                goldMcxTextView.startAnimation(blink_anim);

                goldSolapurTextView =  getView().findViewById(R.id.goldsolapur);
                upperGoldSolapurTextView =  getView().findViewById(R.id.uppergoldsolapur);

                silverMcxTextView =  getView().findViewById(R.id.silvermcx);
                silverSolapurTextView =  getView().findViewById(R.id.silversoplapur);

                upperSilverSolapurTextView = getView().findViewById(R.id.uppersilversoplapur);
                silverHydrabadTextView = getView().findViewById(R.id.silverhydrabad);
                silverMumbaiTextView =  getView().findViewById(R.id.silvermumbai);
                silverKolhapurTextView =  getView().findViewById(R.id.silverkolhapur);


                            goldMcx = Math.round(getGoldData());

                            goldSolapur = Math.round(goldMcx + (goldMcx * 0.03));


                            silverMcx = Math.round(getSilverData());
                            silverSolapur = Math.round(silverMcx + (silverMcx * 0.03) + 100);
                            silverMumbai = silverSolapur - 500;
                            silverKolhapur = silverSolapur - 1100;
                            silverHydrabad = silverSolapur;

//                            handler.postDelayed(this, 5000);
                        }catch(Exception ex) {

//                        }
//                    }
//                }, 10000);
//


//            }catch (Exception ex){
//
//            }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try{


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


                    handler.postDelayed(this, 10000);
                    }catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }, 10000);





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

/*    private boolean isDeviceOnline() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }*/

    private boolean isOnline() {
        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }


}