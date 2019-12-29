import java.util.*;

public class Mazee
{

    public static class Pair
    {
        private int x;
        private int y;
        private int dist;

        public Pair(int x, int y, int dist)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }

        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }

    }

    int [][] mazeBoard;
    Pair source;
    Pair target;
    int x[] = {-1, 1, 0,  0 };
    int y[] = {0,  0, 1, -1 };

    Mazee(int [][] mat ,Pair source, Pair target) {
        this.mazeBoard = new int[10][10];
        this.source = source;
        this.target = target;
    }

    public Boolean isValid(int x, int y)
    {
        return (x>=0 && x<10 )&& (y>=0 && y<10);
    }

    public void findShortestPath()
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(source.getX(),source.getY(),0));
        mazeBoard[source.getX()][source.getY()]=0;

        while(!q.isEmpty())
        {
            Pair current =q.peek();
            if(current.getX()==target.getX() && current.getY()==target.getY())
            {
                System.out.print("Shortest distance is " + mazeBoard[current.getX()][current.getY()]);
                return;
            }
            int currentX=current.getX();
            int currentY=current.getY();
            for(int i=0;i<4;i++)
            {
               if(isValid(currentX + x[i] , currentY + y[i]) && mazeBoard[currentX + x[i]] [currentY + y[i]]==1)
                {
                    q.add(new Pair(currentX+x[i],currentY+y[i],dist+1);
                    mazeBoard[currentX + x[i]][currentY + y[i]] = mazeBoard[currentX][currentY] + 1;
                }
            }
            q.remove();
        }

    }


    public static void main(String[] args) {
        Pair source=new Pair(0,0);
        Pair target=new Pair(3,4);
        int [][] mat=
                {
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                        { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
                };

        Mazee maze =new Mazee(mat ,source, target);
        maze.findShortestPath();
    }
}
