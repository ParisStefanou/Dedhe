/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

/**
 *
 * @author Paris
 */
public class MonthCache {
    
    
    DayCache[] days=new DayCache[31];    
    public MonthCache() {
        for (int i = 0; i < 31; i++) {
            days[i] = new DayCache();
        }
    }
} 
