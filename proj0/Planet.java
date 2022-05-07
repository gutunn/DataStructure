public class Planet {

    public double xxPos,yyPos,xxVel,yyVel,mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
    }

    public double calcForceExertedBy(Planet p) {
        return G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double NetForce = 0;
        for (Planet p : ps) {
            if (!this.equals(p)) {
                NetForce += this.calcForceExertedByX(p);
            }
        }
        return NetForce;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double NetForce = 0;
        for (Planet p : ps) {
            if (!this.equals(p)) {
                NetForce += this.calcForceExertedByY(p);
            }
        }
        return NetForce;
    }

    public void update(double dt, double fx, double fy) {
        this.xxVel += dt * fx / this.mass;
        this.yyVel += dt * fy / this.mass;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
