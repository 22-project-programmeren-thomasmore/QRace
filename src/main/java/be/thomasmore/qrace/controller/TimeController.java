package be.thomasmore.qrace.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/race")
public class TimeController extends HttpServlet {
    private static Map<Integer, Long> playerTimes = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerIDString = request.getParameter("playerID");
        String timeString = request.getParameter("time");
        int playerID = Integer.parseInt(playerIDString);
        long elapsedMilliseconds = Long.parseLong(timeString);

        saveTimeForPlayer(playerID, elapsedMilliseconds);

        PrintWriter out = response.getWriter();
        out.println("Time saved successfully for player " + playerID);
        out.close();
    }

    private void saveTimeForPlayer(int playerId, long elapsedMilliseconds) {
        playerTimes.put(playerId, elapsedMilliseconds);
        System.out.println("Time received for player " + playerId + ": " + elapsedMilliseconds + " milliseconds");
    }
}

