package ma.millergraphics.it.Stock.security;

public interface JwtUtil {

    public static final String SECRET="oji-sama";
    public static final String AUTH_HEADER="Authorization";
    public static final String PREFIX="Bearer ";
    public static final long EXPIRED_ACCESS_TOKEN=4*60*60*1000;
}
