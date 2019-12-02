package com.chenglin.mobileshop.http.service;import com.chenglin.mobileshop.http.entity.GoodsEntity;import com.chenglin.mobileshop.http.entity.HttpResult;import java.util.List;import retrofit2.http.Field;import retrofit2.http.FormUrlEncoded;import retrofit2.http.GET;import retrofit2.http.POST;import retrofit2.http.Path;import rx.Observable;public interface GoodsService {    @FormUrlEncoded    @POST("goods/find")    Observable<HttpResult<List<GoodsEntity>>> listByKeywords(            @Field("input") String keywords    );    /**     * 根据二级分类id获取商品列表     * @param catId     * @return     */    @GET("goods/cat/{catId}")    Observable<HttpResult<List<GoodsEntity>>> list(            @Path("catId")int catId    );}