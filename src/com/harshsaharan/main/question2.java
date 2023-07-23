package com.harshsaharan.main;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class question2 {
	public static boolean findPairWithSum(TreeNode root, int sum) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        TreeNode left = root;
        TreeNode right = root;
        boolean doneLeft = false;
        boolean doneRight = false;
        int leftValue = 0, rightValue = 0;

        while (true) {
        
            while (!doneLeft) {
                if (left != null) {
                    leftStack.push(left);
                    left = left.left;
                } else {
                    if (leftStack.isEmpty()) {
                        doneLeft = true;
                    } else {
                        left = leftStack.pop();
                        leftValue = left.val;
                        left = left.right;
                        doneLeft = true;
                    }
                }
            }

        
            while (!doneRight) {
                if (right != null) {
                    rightStack.push(right);
                    right = right.right;
                } else {
                    if (rightStack.isEmpty()) {
                        doneRight = true;
                    } else {
                        right = rightStack.pop();
                        rightValue = right.val;
                        right = right.left;
                        doneRight = true;
                    }
                }
            }

            if (leftValue != rightValue && leftValue + rightValue == sum) {
                System.out.println("Pair is (" + leftValue + ", " + rightValue + ")");
                return true;
            } else if (leftValue + rightValue < sum) {
                doneLeft = false;
            } else if (leftValue + rightValue > sum) {
                doneRight = false;
            }

            if (leftValue >= rightValue) {
                return false;
            }
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        TreeNode root = new TreeNode(60);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(45);
        root.right.left = new TreeNode(65);
        root.right.right = new TreeNode(80);

       
        int sum = sc.nextInt();

       
        findPairWithSum(root, sum);
    }
}
