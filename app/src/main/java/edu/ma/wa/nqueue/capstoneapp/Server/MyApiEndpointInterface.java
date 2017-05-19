package edu.ma.wa.nqueue.capstoneapp.Server;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zackhillman on 5/8/17.
 */

public interface MyApiEndpointInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter


    @Headers({"Content-Type:application/json" })
    @GET("loc/{name}")
    Call<ResponseBody> getLoc(@Path("name") String name);

    @Headers({"Content-Type:application/json" })
    @GET("log/{date}")
    Call<ResponseBody> getLog(@Path("date") String date);


    @GET("group/{id}/users")
    Call<List<ResponseBody>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("loc/update")
    Call<ResponseBody> updateLocation(@Body MyLocation loc);


}
