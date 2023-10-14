package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/*
    *The MazeSolver class is a Java Swing application that solves and visualizes a maze. 
    * It extends JFrame to create a graphical user interface. 
    * The maze is represented as a 2D array, with walls (1), open paths (0), and a destination (9). 
    * The class finds a solution path through the maze using a depth-first search algorithm and displays the maze and the path on the UI. 
    * The main method initializes the GUI and makes it visible.
 */
public class MazeSolver extends JFrame {
    
    // The maze is represented as a 2D array, where 1 represents walls, 0 represents open paths, and 9 represents the destination.
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    // The `path` list will store the coordinates of the path found through the maze.
    public List<Integer> path = new ArrayList<>();
    
    /**
     * Constructor for the `MazeSolver` class. Initializes the JFrame and finds the solution path in the maze.
     */
    public MazeSolver() {
        setTitle("Maze Solver");
        setSize(640, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path); // Searches for the path through the maze.
        System.out.println(path); // Prints the solution path coordinates to the console.
    }
    
    /**
     * Overrides the `paint` method to draw the maze and the solution path on the UI.
     */
    @Override
    public void paint(Graphics g) {
        g.translate(50, 50);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {    
                Color color;
                switch(maze[i][j]) {
                    case 1:
                        color = Color.RED; // Walls are drawn in red.
                        break;
                    case 9:
                        color = Color.BLUE; // The destination is drawn in blue.
                        break;
                    default:
                        color = Color.WHITE; // Open paths are drawn in white.
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        
        // Draw the solution path in green on the UI.
        for (int i = 0; i < path.size(); i=i+2) {
            int xCord = path.get(i);
            int yCord = path.get(i+1);
            
            g.setColor(Color.GREEN);
            g.fillRect(30*xCord, 30*yCord, 30, 30);
        }
    }
    
    /**
     * The main method creates an instance of the `MazeSolver` class and makes the GUI visible.
     */
    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.setVisible(true);      
    }
}
