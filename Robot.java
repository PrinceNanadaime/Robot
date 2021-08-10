package ForTest;

public class Robot {
    private int x = 0, y = 0; //just for methods working like getX 
    private Direction direction = Direction.UP;//just for methods working like getDirection

    public static void moveRobot(Robot robot, int toX, int toY) {
        try{
            alignmentX(robot, robot.getDirection(), robot.getX(), toX);
            alignmentY(robot, alignmentX(robot, robot.getDirection(), robot.getX(), toX), robot.getY(), toY);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Direction alignmentX(Robot robot, Direction oldDirection, int fromX, int toX){
        if(fromX != toX){
            if(oldDirection == Direction.UP){
                if(fromX > toX){
                    robot.turnLeft();
                    for(int i = 1; i <= fromX - toX; i++){
                        robot.stepForward();
                    }
                    return Direction.LEFT;
                } else{
                    robot.turnRight();
                    for(int i = 1; i <= toX - fromX; i++){
                        robot.stepForward();
                    }
                    return Direction.RIGHT;
                }
            } else if(oldDirection == Direction.LEFT){
                if(fromX > toX){
                    for(int i = 1; i <= fromX - toX; i++){
                        robot.stepForward();
                    }
                    return Direction.LEFT;
                } else{
                    robot.turnRight();
                    robot.turnRight();
                    for(int i = 1; i <= toX - fromX; i++){
                        robot.stepForward();
                    }
                    return Direction.RIGHT;
                }

            } else if(oldDirection == Direction.RIGHT){
                if(fromX > toX){
                    robot.turnRight();
                    robot.turnRight();
                    for(int i = 1; i <= fromX - toX; i++){
                        robot.stepForward();
                    }
                    return Direction.LEFT;
                } else{
                    for(int i = 1; i <= toX - fromX; i++){
                        robot.stepForward();
                    }
                    return Direction.RIGHT;
                }
            } else{ //Direction.DOWN
                if(fromX > toX){
                    robot.turnRight();
                    for(int i = 1; i <= fromX - toX; i++){
                        robot.stepForward();
                    }
                    return Direction.LEFT;
                } else{
                    robot.turnLeft();
                    for(int i = 1; i <= toX - fromX; i++){
                        robot.stepForward();
                    }
                    return Direction.RIGHT;
                }
            }
        }
        return oldDirection;
    }

    public static Direction alignmentY(Robot robot, Direction oldDirection, int fromY, int toY){
        if(fromY != toY){
            if(oldDirection == Direction.UP){
                if(fromY > toY){
                    robot.turnLeft();
                    robot.turnLeft();
                    for(int i = 1; i <= fromY - toY; i++){
                        robot.stepForward();
                    }
                    return Direction.DOWN;
                } else{
                    for(int i = 1; i <= toY - fromY; i++){
                        robot.stepForward();
                    }
                    return Direction.UP;
                }
            } else if(oldDirection == Direction.LEFT){
                if(fromY > toY){
                    robot.turnLeft();
                    for(int i = 1; i <= fromY - toY; i++){
                        robot.stepForward();
                    }
                    return Direction.DOWN;
                } else{
                    robot.turnRight();
                    for(int i = 1; i <= toY - fromY; i++){
                        robot.stepForward();
                    }
                    return Direction.UP;
                }
            } else if(oldDirection == Direction.RIGHT){
                if(fromY > toY){
                    robot.turnRight();
                    for(int i = 1; i <= fromY - toY; i++){
                        robot.stepForward();
                    }
                    return Direction.DOWN;
                } else{
                    robot.turnLeft();
                    for(int i = 1; i <= toY - fromY; i++){
                        robot.stepForward();
                    }
                    return Direction.UP;
                }
            } else{ // Direction.Down
                if(fromY > toY){
                    for(int i = 1; i <= fromY - toY; i++){
                        robot.stepForward();
                    }
                    return Direction.DOWN;
                } else{
                    robot.turnLeft();
                    robot.turnLeft();
                    for(int i = 1; i <= toY - fromY; i++){
                        robot.stepForward();
                    }
                    return Direction.UP;
                }
            }
        }
        return oldDirection;
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}