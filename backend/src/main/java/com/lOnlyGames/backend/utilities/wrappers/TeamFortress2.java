package com.lOnlyGames.backend.utilities.wrappers;

import com.lOnlyGames.backend.utilities.APIFetcher;
import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.playerstats.Stat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TeamFortress2 {

    List<Stat> stats;

    public TeamFortress2(String steamID) throws SteamApiException {
         stats = APIFetcher.getGameStats(steamID,440);

    }

    public double resolvePlayTime()
    {
        double totalPlaytime = 0;
        for (int i = 0; i < stats.size(); ++i) {
            if (stats.get(i).getName().equals("Scout.accum.iPlayTime")) {
                totalPlaytime += stats.get(i).getValue().doubleValue();
                if (stats.get(i).getName().equals("Soldier.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
                if (stats.get(i).getName().equals("Spy.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
                if (stats.get(i).getName().equals("Pyro.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
                if (stats.get(i).getName().equals("Medic.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
                if (stats.get(i).getName().equals("Demoman.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
                if (stats.get(i).getName().equals("Heavy.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
                if (stats.get(i).getName().equals("Engineer.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
                if (stats.get(i).getName().equals("Sniper.accum.iPlayTime")) {
                    totalPlaytime += stats.get(i).getValue().doubleValue();
                }
            }

        }
        return totalPlaytime/60/60;
    }

    public String resolveTF2Kills() throws SteamApiException {

        String totalKills = "";
        for(int i = 0; i<stats.size(); ++i) {
            if(stats.get(i).getName().equals("Scout.accum.iNumberOfKills"))
            {
                totalKills += "Scout Total Kills " + stats.get(i).getValue() + "\n";
            }
            if(stats.get(i).getName().equals("Soldier.accum.iNumberOfKills"))
            {
                totalKills += "Soldier Total Kills: " + stats.get(i).getValue()+"\n";
            }
            if(stats.get(i).getName().equals("Spy.accum.iNumberOfKills"))
            {
                totalKills += "Spy Total Kills: " + stats.get(i).getValue()+"\n";
            }
            if(stats.get(i).getName().equals("Pyro.accum.iNumberOfKills"))
            {
                totalKills += "Pyro Total Kills: " + stats.get(i).getValue()+"\n";
            }
            if(stats.get(i).getName().equals("Medic.accum.iNumberOfKills"))
            {
                totalKills += "Medic Total Kills: " + stats.get(i).getValue()+"\n";
            }
            if(stats.get(i).getName().equals("Demoman.accum.iNumberOfKills"))
            {
                totalKills += "Demolition Total Kills: " + stats.get(i).getValue()+"\n";
            }
            if(stats.get(i).getName().equals("Heavy.accum.iNumberOfKills"))
            {
                totalKills += "Heavy Total Kills: " + stats.get(i).getValue()+"\n";
            }
            if(stats.get(i).getName().equals("Engineer.accum.iNumberOfKills"))
            {
                totalKills += "Engineer Total Kills: " + stats.get(i).getValue()+"\n";
            }
            if(stats.get(i).getName().equals("Sniper.accum.iNumberOfKills"))
            {
                totalKills += "Sniper Total Kills: " + stats.get(i).getValue()+"\n";
            }
        }
        double totalKill = Double.parseDouble(totalKills);
        BigDecimal bd = BigDecimal.valueOf(totalKill);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return Double.toString(bd.doubleValue());

    }}
