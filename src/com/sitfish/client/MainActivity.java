package com.sitfish.client;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Yunlong Jiang on 4/19/15.
 */
public class MainActivity extends Activity {

    private MediaPlayer mediaPlayer;
    private Button playButton;
    private String musicUri;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    private void initView() {
        mediaPlayer = new MediaPlayer();
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CallSitFishAPI().execute("http://api.sitfish.com/v1/songs/29713754");
            }
        });
    }

    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    public class CallSitFishAPI extends AsyncTask<String, String, JSONObject> {
        Exception mException = null;

        @Override
        protected JSONObject doInBackground(String... urls) {
            InputStream inputStream = null;
            JSONObject object = null;
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse httpResponse = httpclient.execute(new HttpGet(urls[0]));
                inputStream = httpResponse.getEntity().getContent();

                BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp, response = "";
                while ((temp = bReader.readLine()) != null)
                    response += temp;
                bReader.close();
                inputStream.close();
                object = (JSONObject) new JSONTokener(response).nextValue();
            } catch (Exception e) {
                this.mException = e;
            }

            return (object);
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(JSONObject jsonResult) {
            try {
                JSONObject jsonSongs = jsonResult.getJSONObject("songs");
                musicUri = jsonSongs.getString("mp3Url");
                //TODO
                if (!mediaPlayer.isPlaying()) {
                    Log.d("URL", "Music url: " + musicUri);
                    mediaPlayer = MediaPlayer.create(MainActivity.this,
                            Uri.parse(musicUri));
                    mediaPlayer.start();
                    playButton.setText(getApplicationContext().getResources().getString(R.string.Pause));
                } else {
                    mediaPlayer.pause();
                    playButton.setText(getApplicationContext().getResources().getString(R.string.Continue));
                }
            }catch(JSONException e){

            }
        }
    }

}
