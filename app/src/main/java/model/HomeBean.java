package model;

/**
 * 类    名:  HomeBean
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/16
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/16: 12:05$
 * 描    述： ${TODO}
 */

public class HomeBean
{

    /**
     * type : ACTIVITY
     * id : 0
     * title : GOT7三周年周边商品合辑
     * description :
     * posterPic : http://img3.c.yinyuetai.com/others/mobile_front_page/170116/0/-M-f4a83d28829db7f6184a34ae08429485_0x0.jpg
     * url : http://activity.shop.yinyuetai.com/index.html#/Activity/30?_k=cqhik1
     * videoSize : 0
     * hdVideoSize : 0
     * uhdVideoSize : 0
     * status : 0
     * traceUrl : http://www.yinyuetai.com/v?a=102437&un=53a621a9362eb7ed4e46425ac834f4b545fe1eff443acb1e2ba5fdc547da9314f66a78b03b640904a24e6f25376102b0c1dc16842b2b37e0d446aaffccd10a8cf69d2ebc6c2e79bfe31b925f005aee7e12ef159d573c37c97845c34d5e9dc329d8763c9a0e375997
     * clickUrl : http://mapi.yinyuetai.com/statistics/click.json?id=5115
     */

    private String type;
    private int    id;
    private String title;
    private String description;
    private String posterPic;
    private String url;
    private int    videoSize;
    private int    hdVideoSize;
    private int    uhdVideoSize;
    private int    status;
    private String traceUrl;
    private String clickUrl;

    public String getType() { return type;}

    public void setType(String type) { this.type = type;}

    public int getId() { return id;}

    public void setId(int id) { this.id = id;}

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description;}

    public String getPosterPic() { return posterPic;}

    public void setPosterPic(String posterPic) { this.posterPic = posterPic;}

    public String getUrl() { return url;}

    public void setUrl(String url) { this.url = url;}

    public int getVideoSize() { return videoSize;}

    public void setVideoSize(int videoSize) { this.videoSize = videoSize;}

    public int getHdVideoSize() { return hdVideoSize;}

    public void setHdVideoSize(int hdVideoSize) { this.hdVideoSize = hdVideoSize;}

    public int getUhdVideoSize() { return uhdVideoSize;}

    public void setUhdVideoSize(int uhdVideoSize) { this.uhdVideoSize = uhdVideoSize;}

    public int getStatus() { return status;}

    public void setStatus(int status) { this.status = status;}

    public String getTraceUrl() { return traceUrl;}

    public void setTraceUrl(String traceUrl) { this.traceUrl = traceUrl;}

    public String getClickUrl() { return clickUrl;}

    public void setClickUrl(String clickUrl) { this.clickUrl = clickUrl;}
}
