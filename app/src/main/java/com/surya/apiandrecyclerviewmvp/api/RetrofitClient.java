package com.surya.apiandrecyclerviewmvp.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL="http://api.androiddeft.com/";

    private static RetrofitClient mInstance;
    private Retrofit retrofit;



    private RetrofitClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        retrofit=new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null){
            mInstance = new RetrofitClient();


        }
        return mInstance;
    }


    /*private static OkHttpClient provideOkHttpClient(final Context context) {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                //  .addNetworkInterceptor(provideCacheInterceptor(context))
                // .addInterceptor(provideOfflineCacheInterceptor(context))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder ongoing = chain.request().newBuilder();

                        Log.d("intercept", "intercept: " + context);
                        SharedPreferences sharedPreferences =  context.getSharedPreferences("authPref",Context.MODE_PRIVATE);
                        ongoing.addHeader("Authorization", sharedPreferences.getString("authToken" , ""));
                        ongoing.addHeader("Content-Type", "application/x-www-form-urlencoded");
                        ongoing.addHeader("Accept", "application/json");
                        return chain.proceed(ongoing.build());
                    }
                })
                .build();
    }*/

    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }
}

