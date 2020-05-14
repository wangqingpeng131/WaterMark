package com.getwatermark.photomaker.plugin.ccnicegreate;

import com.getwatermark.photomaker.plugin.ccnicegreate.dd.CC;
import com.getwatermark.photomaker.plugin.ccnicegreate.dd.DD;
import com.getwatermark.photomaker.plugin.ccnicegreate.dd.LL;
import com.getwatermark.photomaker.plugin.ccnicegreate.dd.Pp;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author Afra55
 * @date 2018/4/17
 * A smile is the best business card.
 */
public interface CModel {

    @GET("http://ip-api.com/json")
    Observable<CC> getIpInfoTwo();

    @GET("http://ip-api.com/json")
    Observable<DD> getIpInfoThree();

    @POST("api/misc/clientevent")
    Observable<LL> uploadIpInfo(@QueryMap Map<String, Object> map, @Body Object data);

    @GET("api/cfg")
    Observable<String> cfg(@QueryMap Map<String, Object> map);

    @GET("androidpluginapi/get")
    Observable<Pp> getPpInfo(@QueryMap Map<String, Object> map);
}
