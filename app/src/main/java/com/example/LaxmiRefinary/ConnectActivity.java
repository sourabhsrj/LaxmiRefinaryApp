package com.example.LaxmiRefinary;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ConnectActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent home = new Intent(ConnectActivity.this,HomeActivity.class);
                        startActivity(home);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.navigation_ads:
                        Intent ads = new Intent(ConnectActivity.this,Ads.class);
                        startActivity(ads);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.navigation_connect:
                        break;

                }
                return false;
            }
        });

    }


    public void calling(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:7775078124"));
        startActivity(callIntent);
    }



    public void openMail(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        String[] recipients={"laxmisilver9950@gmail.com"};
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
        intent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
        intent.putExtra(Intent.EXTRA_CC,"laxmisilver9950@gmail.com");
        intent.setType("text/html");
        intent.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(intent, "Send mail"));
    }

    public void openWhatsapp(View view) {
        try {
            String text = "Hello....From Laxmi Refinary App";
            String toNumber = "917775078124";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void openTwitter(View view) {
        try{
            /*Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, " Hello " + " ");
            intent.setType("text/plain");
            final PackageManager pm = getPackageManager();
            final List<?> activityList = pm.queryIntentActivities(intent, 0);
            int len =  activityList.size();
            for (int i = 0; i < len; i++) {
                final ResolveInfo app = (ResolveInfo) activityList.get(i);
                if ("com.twitter.applib.PostActivity".equals(app.activityInfo.name)) {
                    final ActivityInfo activity=app.activityInfo;
                    final ComponentName x=new ComponentName(activity.applicationInfo.packageName, activity.name);
                    intent=new Intent(Intent.ACTION_SEND);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    intent.setComponent(x);
                    intent.putExtra(Intent.EXTRA_TEXT, " " );
                    startActivity(intent);
                    break;
                }
            }*/
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/direct_messages/create/laxmisilver9950")));
        } catch(final ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/direct_messages/create/laxmisilver9950")));
        }
    }

    public void openFacebook(View view) {
        try {
            getPackageManager().getPackageInfo("com.facebook.laxmisilver9950", 0);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/laxmisilver9950")));
        } catch (Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/laxmisilver9950")));
        }
    }
    public void openInstagram(View view) {
        Uri uri = Uri.parse("https://instagram.com/laxmi_silver_9950?igshid=8hy2psf7kfng");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://instagram.com/laxmi_silver_9950?igshid=8hy2psf7kfng")));
        }

    }

    public void openMap(View view) {
        Uri gmmIntentUri = Uri.parse("https://goo.gl/maps/2S6KTRNywBeiNPSt7");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}