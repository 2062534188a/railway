package com.railway.Utils;

import com.railway.Constants.ResultConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    //响应码
    private Integer code;
    //提示信息
    private String msg;
    //返回的数据
    private Object data;

    /**
     * 请求成功 200
     * @return 封装好的Result对象
     */
    public static Result success(){
        return new Result(ResultConstants.RESULT_CODE_TRUE,ResultConstants.SUCCESS,"true");
    }
    /**
     * 请求成功 200
     * @param data 返回数据
     * @return 封装好的Result对象
     */
    public static Result success(Object data){
        return new Result(ResultConstants.RESULT_CODE_TRUE,ResultConstants.SUCCESS,data);
    }


    /**
     * 请求成功 200
     * @param msg 描述信息
     * @param data 返回数据
     * @return 封装好的Result对象
     */
    public static Result success(String msg,Object data){
        return new Result(ResultConstants.RESULT_CODE_TRUE,msg,data);
    }

    /**
     * 请求成功 200
     * @param list 返回值数据封装成集合
     * @return 封装好的Result对象
     */
    public static Result success(List<Object> list){
        return new Result(ResultConstants.RESULT_CODE_TRUE,ResultConstants.SUCCESS,list);
    }

    /**
     * 请求成功 200
     * @param msg 描述信息
     * @param list 返回值数据封装成集合
     * @return 封装好的Result对象
     */
    public static Result success(String msg,List<Object> list){
        return new Result(ResultConstants.RESULT_CODE_TRUE,msg,list);
    }

    /**
     * 请求异常 400
     * @param msg 描述信息
     * @return 封装好的Result对象
     */
    public static Result error(String msg){
        return new Result(ResultConstants.RESULT_CODE_ERROR,msg,null);
    }
    /**
     * 请求异常 404
     * @return 封装好的Result对象
     */
    public static Result error(){
        return new Result(ResultConstants.RESULT_CODE_NULL,"页面不存在",null);
    }
}
