package model;

import java.util.List;

/**
 * 类    名:  MVBean
 * 创 建 者:  Zzh
 * 创建时间:  2017/1/18
 * 更新者  :  $Author: admin $
 * 更新时间:  2017/1/18: 12:42$
 * 描    述： ${TODO}
 */

public class MVBean
{

    /**
     * name : 首播
     * code : FS
     */

    public List<MVPageBean> list;
    public class MVPageBean
    {
        private String name;
        private String code;

        public String getName() { return name;}

        public void setName(String name) { this.name = name;}

        public String getCode() { return code;}

        public void setCode(String code) { this.code = code;}
    }
}
