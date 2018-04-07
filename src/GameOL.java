import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class GameOL {
    public static void countNeighbors(ArrayList<Cell> BusyCells,ArrayList<Cell> EmptyCells){
        int n =0;
        for(Cell cell : BusyCells){
            for(Cell neighbor: BusyCells){
                if(neighbor!=cell &&
                        neighbor.getCol()<=cell.getCol()+1 && neighbor.getCol()>=cell.getCol()-1 &&
                        neighbor.getRow()<=cell.getRow()+1 && neighbor.getRow()>=cell.getRow()-1){
                    n++;
                }
            }
            cell.setNeightbors(n);
            n=0;
        }
        for(Cell cell : EmptyCells){
            for(Cell neighbor: BusyCells){
                if(neighbor.getCol()<=cell.getCol()+1 && neighbor.getCol()>=cell.getCol()-1 &&
                        neighbor.getRow()<=cell.getRow()+1 && neighbor.getRow()>=cell.getRow()-1){
                    n++;
                }
            }
            cell.setNeightbors(n);
            n=0;
        }
    }

    public static void cycle(ArrayList<Cell> BusyCells, ArrayList<Cell> EmptyCells){
        ArrayList<Cell> removelist = new ArrayList<>();

        for (Cell cell: BusyCells){
            if (cell.getNeightbors()<=1||cell.getNeightbors()>=4){
                removelist.add(cell);
//                EmptyCells.add(new Cell(cell.getRow(),cell.getCol()));
//                BusyCells.remove(cell);
            }
        }
        for(Cell cell:removelist){
            BusyCells.remove(cell);
            EmptyCells.add(cell);
        }
        removelist.clear();
        for (Cell cell : EmptyCells){
            if (cell.getNeightbors()==3){
                removelist.add(cell);
            }
        }
        for(Cell cell:removelist){
            EmptyCells.remove(cell);
            BusyCells.add(cell);
        }
        removelist.clear();
    }


    public static void main(String[] args){
        BufferedReader inreader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Cell> BusyCells = new ArrayList<>();
        ArrayList<Cell> EmptyCells = new ArrayList<>();
        try {
            String size = inreader.readLine();
            int rows = Integer.parseInt(size.split(" ")[0]);
            int cols = Integer.parseInt(size.split(" ")[1]);
            for (int i = 0; i<rows; i++){
                String inLine = inreader.readLine();
                for (int j = 0; j<cols;j++){
                    if (inLine.toCharArray()[j]=='@'){
                        BusyCells.add(new Cell(i,j));
                    }
                    if (inLine.toCharArray()[j]=='#'){
                        EmptyCells.add(new Cell(i,j));
                    }
                }
            }
            int cycles = Integer.parseInt(inreader.readLine());
            for (int i=0;i<cycles;i++){
                countNeighbors(BusyCells,EmptyCells);
                cycle(BusyCells,EmptyCells);
            }
            System.out.print(BusyCells.size());

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
