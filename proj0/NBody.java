public class NBody {

    public static double readRadius(String path) {
        In in = new In(path);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path) {
        Planet[] Ps = new Planet[5];
        In in = new In(path);
        in.readInt();
        in.readDouble();
        for (int i = 0; i < 5; i++) {
            Ps[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return Ps;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double Radius = readRadius(filename);
        Planet[] Ps = readPlanets(filename);
        StdAudio.play("audio/2001.mid");
        StdDraw.setScale(-Radius, Radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : Ps) {
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        for (double t = 0; t < T; t = t + dt) {
            double[] xForces = new double[5], yForces = new double[5];
            for (int j = 0; j < 5; j++) {
                xForces[j] = Ps[j].calcNetForceExertedByX(Ps);
                yForces[j] = Ps[j].calcNetForceExertedByY(Ps);
            }
            for (int i = 0; i < 5; i++) {
                Ps[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : Ps) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", Ps.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < Ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Ps[i].xxPos, Ps[i].yyPos, Ps[i].xxVel,
                    Ps[i].yyVel, Ps[i].mass, Ps[i].imgFileName);
        }
    }
}
