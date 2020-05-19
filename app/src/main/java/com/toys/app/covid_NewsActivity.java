package com.toys.app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class covid_NewsActivity extends AppCompatActivity {

    private static final String TAG="covid_NewsActivity";
    private ArrayList<NewsModel> news;
    private RecyclerView recyclerView;
    private ListNewsAdapter Adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        setContentView(R.layout.activity_covid__news);
        getSupportActionBar().setTitle("LATEST NEWS!!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        news=new ArrayList<>();
        recyclerView = findViewById(R.id.news_list);
        Adapter=new ListNewsAdapter(this);
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new GetNews().execute();
    }

    private class GetNews extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            InputStream inputStream = getInputStream();
            if (null != inputStream) {
                try {
                    initXMLPullParser(inputStream);
                }
                catch (XmlPullParserException | IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Adapter.setNews(news);
        }

        private InputStream getInputStream() {
            try {

                URL url = new URL("http://feeds.feedburner.com/ndtvnews-top-stories?format=xml");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                return connection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        private void initXMLPullParser(InputStream inputStream) throws XmlPullParserException, IOException {

            Log.d(TAG, "initXMLPullParser: Initialising XML pull parser");
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            parser.next();

            parser.require(XmlPullParser.START_TAG, null, "rss");
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }

                parser.require(XmlPullParser.START_TAG, null, "channel");
                while (parser.next() != XmlPullParser.END_TAG) {
                    if (parser.getEventType() != XmlPullParser.START_TAG) {
                        continue;
                    }


                    if (parser.getName().equals("item")) {
                        parser.require(XmlPullParser.START_TAG, null, "item");

                        String title="";
                        String description="";
                        String link="";
                        String pubdate="";
                        String coverImage="";

                        while (parser.next() != XmlPullParser.END_TAG) {
                            if (parser.getEventType() != XmlPullParser.START_TAG) {
                                continue;
                            }
                            String tagName = parser.getName();
                            if (tagName.equals("title")) {

                            title=getContent(parser,"title");
                            } else if (tagName.equals("description")) {
                                description=getContent(parser,"description");
                            }
                            else if (tagName.equals("link")) {
                                link=getContent(parser,"link");
                            }

                            else if (tagName.equals("pubdate")) {
                                pubdate=getContent(parser,"pubdate");
                            }
                            else
                                {
                                skipTag(parser);
                                }
                        }
                        NewsModel item=new NewsModel(title,description,link,pubdate,coverImage);
                        news.add(item);
                    }
                    else
                        {
                            skipTag(parser);
                        }

                }

            }

        }
    }

    private String getContent(XmlPullParser parser, String tagName) throws IOException, XmlPullParserException {

        String content="";
        parser.require(XmlPullParser.START_TAG,null,tagName);
        if(parser.next()==XmlPullParser.TEXT){
            content=parser.getText();
            parser.next();
        }
    return content;
    }

public void skipTag(XmlPullParser parser) throws XmlPullParserException, IOException {
        if(parser.getEventType()!=XmlPullParser.START_TAG){
            throw new IllegalStateException();
        }
        int number=1;
        while(number!=0){
            switch (parser.next()){
                case XmlPullParser.START_TAG:
                    number++;
                    break;
                case XmlPullParser.END_TAG:
                    number--;
                    break;
                    default:
                        break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivityForResult(myIntent, 0);

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}