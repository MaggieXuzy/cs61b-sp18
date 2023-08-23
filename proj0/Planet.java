public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet P){
        xxPos = P.xxPos;
        yyPos = P.yyPos;
        xxVel = P.xxVel;
        yyVel = P.yyVel;
        mass = P.mass;
        imgFileName = P.imgFileName;
    }

    public double calcDistance(Planet P){
        return Math.sqrt((P.xxPos - xxPos) * (P.xxPos - xxPos) + (P.yyPos - yyPos) * (P.yyPos - yyPos));
    }

    public double calcForceExertedBy(Planet P){
        return G * P.mass * mass / (calcDistance(P) * calcDistance(P));
    }

    public double calcForceExertedByX(Planet P){
        return calcForceExertedBy(P) * (P.xxPos - xxPos) / calcDistance(P);
    }

    public double calcForceExertedByY(Planet P){
        return calcForceExertedBy(P) * (P.yyPos - yyPos) / calcDistance(P);
    }

    public double calcNetForceExertedByX(Planet[] P){
        double res = 0.0;
        for (int i = 0; i < P.length; i++){
            if (!P[i].equals(this)){
                res += calcForceExertedByX(P[i]);
            }
        }
        return res;
    }

    public double calcNetForceExertedByY(Planet[] P){
        double res = 0.0;
        for (int i = 0; i < P.length; i++){
            if (!P[i].equals(this)){
                res += calcForceExertedByY(P[i]);
            }
        }
        return res;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
       StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }



}
