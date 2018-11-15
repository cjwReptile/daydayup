package HomeWorkManager.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Map;

/**
 * Created by cjw on 2017/12/14.
 */
public class JwtUtils {

    static PropertiesUtil propertiesUtil=new PropertiesUtil("/properties/daydayup.properties");



   /* public static void main(String[] args){
        Long cur=System.currentTimeMillis();
        String time=cur.toString();
        String jwt=encodeJwt("mwy",SignatureAlgorithm.HS256);
        Claims claims=decodeJwt(jwt);
        System.out.println("");
    }*/




    public static String encodeJwt(String clientKey,SignatureAlgorithm signatureAlgorithm,Map<String,Object> map){
        long curtime=System.currentTimeMillis();
        byte[] secretKey= DatatypeConverter.parseBase64Binary(propertiesUtil.getValue("secret"));
        JwtBuilder jwt= Jwts.builder();
        jwt.setSubject(clientKey);
        String timestamp=propertiesUtil.getValue("timeout");
        if(null!=timestamp){
            Date ex=new Date(Long.parseLong(timestamp)*60L*1000+curtime);
            jwt.setExpiration(ex);
        }
        //加入用户信息
        if(map!=null){
            for(Map.Entry<String,Object> entry : map.entrySet()){
                jwt.claim(entry.getKey(),entry.getValue());
            }
        }
        jwt.compressWith(CompressionCodecs.DEFLATE);
        jwt.signWith(signatureAlgorithm,secretKey);
        return jwt.compact();
    }

    public static Claims decodeJwt(String jwt){
        Claims claims=Jwts.parser()
                .setSigningKey(DatatypeConverter.
                        parseBase64Binary(propertiesUtil.getValue("secret"))).parseClaimsJws(jwt).getBody();
       return claims;
    }
}
