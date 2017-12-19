package HomeWorkManager.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

/**
 * Created by cjw on 2017/12/14.
 */
public class JwtUtils {

    static PropertiesUtil propertiesUtil=new PropertiesUtil("/properties/daydayup.properties");


/*
    public static void main(String[] args){
        Long cur=System.currentTimeMillis();
        String time=cur.toString();
        String jwt=encodeJwt("mwy",time,SignatureAlgorithm.HS256);
        decodeJwt(jwt);

    }
*/



    public static String encodeJwt(String clientKey,SignatureAlgorithm signatureAlgorithm){
        long curtime=System.currentTimeMillis();
        byte[] secretKey= DatatypeConverter.parseBase64Binary(propertiesUtil.getValue("secret"));
        JwtBuilder jwt= Jwts.builder();
        jwt.setSubject(clientKey);
        String timestamp=propertiesUtil.getValue("timeout");
        if(null!=timestamp){
            System.out.println(Long.parseLong(timestamp));
            Date ex=new Date(Long.parseLong(timestamp));
            jwt.setExpiration(ex);
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
