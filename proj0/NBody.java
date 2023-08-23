public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int number = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int number = in.readInt();
        double radius = in.readDouble();
        Planet[] arr = new Planet[number];
        for (int i = 0; i < number; i++){
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double m = in.readDouble();
            String file = in.readString();
            arr[i] = new Planet(xPos, yPos, xVel, yVel, m, file);
        }
        return arr;

    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] P = readPlanets(filename);

        StdDraw.setScale(-radius, radius);

        StdDraw.clear();

        StdDraw.picture(0, 0, "images/starfield.jpg");
        StdDraw.show();
        StdDraw.pause(2000);


        for (Planet i : P){
            i.draw();
        }

        StdDraw.enableDoubleBuffering();

        double t = 0.0;
        while (t != T){

            double[] xForces = new double[P.length];
            double[] yForces = new double[P.length];

            for (int i = 0; i < P.length; i++) {
                xForces[i] = P[i].calcNetForceExertedByX(P);
                yForces[i] = P[i].calcNetForceExertedByY(P);
            }

            for (int i = 0; i < P.length; i++){
                P[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");

            for (Planet i : P) {
                i.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;

        }

        StdOut.printf("%d\n", P.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < P.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    P[i].xxPos, P[i].yyPos, P[i].xxVel,
                    P[i].yyVel, P[i].mass, P[i].imgFileName);
        }
    }
}
