package de.goatfryed.pm.battleships.model.tables;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import de.goatfryed.pm.battleships.model.Player;

import de.goatfryed.pm.battleships.model.Game;

import de.goatfryed.pm.battleships.model.Boat;

import de.goatfryed.pm.battleships.model.Shot;

import java.util.Arrays;

import java.util.function.Predicate;

import java.util.LinkedHashSet;

import de.goatfryed.pm.battleships.model.Section;

public class PlayerTable  
{

   public PlayerTable(Player... start)
   {
      this.setColumnName("Player");
      columnMap.put(this.getColumnName(), 0);
      for (Player current : start)
      {
         ArrayList<Object> row = new ArrayList<>();
         row.add(current);
         table.add(row);
      }
   }

   private ArrayList<ArrayList<Object>> table = new ArrayList<>();

   public ArrayList<ArrayList<Object>> getTable()
   {
      return table;
   }

   public PlayerTable setTable(ArrayList<ArrayList<Object>> value)
   {
      this.table = value;
      return this;
   }


   private String columnName = null;

   public String getColumnName()
   {
      return columnName;
   }

   public PlayerTable setColumnName(String value)
   {
      this.columnName = value;
      return this;
   }


   private LinkedHashMap<String, Integer> columnMap = new LinkedHashMap<>();

   public LinkedHashMap<String, Integer> getColumnMap()
   {
      return columnMap;
   }

   public PlayerTable setColumnMap(LinkedHashMap<String, Integer> value)
   {
      this.columnMap = value;
      return this;
   }


   public StringTable expandName(String... rowName)
   {
      StringTable result = new StringTable();
      result.setColumnMap(this.columnMap);
      result.setTable(this.table);
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;
      String newColumnName = rowName != null && rowName.length > 0 ? rowName[0] : "" + ((char)('A' + newColumnNumber));
      result.setColumnName(newColumnName);
      columnMap.put(newColumnName, newColumnNumber);

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getName());
         this.table.add(newRow);
      }
      return result;
   }

   public GameTable expandGame(String... rowName)
   {
      GameTable result = new GameTable();
      result.setColumnMap(this.columnMap);
      result.setTable(table);
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;

      String newColumnName = rowName != null && rowName.length > 0 ? rowName[0] : "" + ((char)('A' + newColumnNumber));
      result.setColumnName(newColumnName);
      columnMap.put(newColumnName, newColumnNumber);

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getGame());
         this.table.add(newRow);
      }
      return result;
   }

   public PlayerTable hasGame(GameTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         Game other = (Game) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getGame() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public GameTable expandActive(String... rowName)
   {
      GameTable result = new GameTable();
      result.setColumnMap(this.columnMap);
      result.setTable(table);
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;

      String newColumnName = rowName != null && rowName.length > 0 ? rowName[0] : "" + ((char)('A' + newColumnNumber));
      result.setColumnName(newColumnName);
      columnMap.put(newColumnName, newColumnNumber);

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getActive());
         this.table.add(newRow);
      }
      return result;
   }

   public PlayerTable hasActive(GameTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         Game other = (Game) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getActive() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public GameTable expandGameWon(String... rowName)
   {
      GameTable result = new GameTable();
      result.setColumnMap(this.columnMap);
      result.setTable(table);
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;

      String newColumnName = rowName != null && rowName.length > 0 ? rowName[0] : "" + ((char)('A' + newColumnNumber));
      result.setColumnName(newColumnName);
      columnMap.put(newColumnName, newColumnNumber);

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getGameWon());
         this.table.add(newRow);
      }
      return result;
   }

   public PlayerTable hasGameWon(GameTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         Game other = (Game) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getGameWon() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public BoatTable expandBoats(String... rowName)
   {
      BoatTable result = new BoatTable();
      result.setColumnMap(this.columnMap);
      result.setTable(table);
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;

      String newColumnName = rowName != null && rowName.length > 0 ? rowName[0] : "" + ((char)('A' + newColumnNumber));
      result.setColumnName(newColumnName);
      columnMap.put(newColumnName, newColumnNumber);

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         for (Boat current : start.getBoats())
         {
            ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
            newRow.add(current);
            this.table.add(newRow);
         }
      }
      return result;
   }

   public PlayerTable hasBoats(BoatTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         Boat other = (Boat) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getBoats().contains(other))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public ShotTable expandShots(String... rowName)
   {
      ShotTable result = new ShotTable();
      result.setColumnMap(this.columnMap);
      result.setTable(table);
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;

      String newColumnName = rowName != null && rowName.length > 0 ? rowName[0] : "" + ((char)('A' + newColumnNumber));
      result.setColumnName(newColumnName);
      columnMap.put(newColumnName, newColumnNumber);

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         for (Shot current : start.getShots())
         {
            ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
            newRow.add(current);
            this.table.add(newRow);
         }
      }
      return result;
   }

   public PlayerTable hasShots(ShotTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         Shot other = (Shot) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getShots().contains(other))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public PlayerTable selectColumns(String... columnNames)
   {
      LinkedHashMap<String, Integer> oldColumnMap = (LinkedHashMap<String, Integer>) this.columnMap.clone();
      this.columnMap.clear();

      int i = 0;
      for (String name : columnNames)
      {
         if (oldColumnMap.get(name) == null)
            throw new IllegalArgumentException("unknown column name: " + name);
         this.columnMap.put(name, i);
         i++;
      }

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();

      LinkedHashSet<ArrayList<Object> > rowSet = new LinkedHashSet<>();
      for (ArrayList row : oldTable)
      {
         ArrayList newRow = new ArrayList();
         for (String name : columnNames)
         {
            Object value = row.get(oldColumnMap.get(name));
            newRow.add(value);
         }
         if (rowSet.add(newRow))
            this.table.add(newRow);
      }

      return this;
   }

   public PlayerTable dropColumns(String... columnNames)
   {
      LinkedHashMap<String, Integer> oldColumnMap = (LinkedHashMap<String, Integer>) this.columnMap.clone();
      this.columnMap.clear();

      LinkedHashSet<String> dropNames = new LinkedHashSet<>();
      dropNames.addAll(Arrays.asList(columnNames));
      int i = 0;
      for (String name : oldColumnMap.keySet())
      {
         if ( ! dropNames.contains(name))
         {
            this.columnMap.put(name, i);
            i++;
         }
      }

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();

      LinkedHashSet<ArrayList<Object> > rowSet = new LinkedHashSet<>();
      for (ArrayList row : oldTable)
      {
         ArrayList newRow = new ArrayList();
         for (String name : this.columnMap.keySet())
         {
            Object value = row.get(oldColumnMap.get(name));
            newRow.add(value);
         }
         if (rowSet.add(newRow))
            this.table.add(newRow);
      }

      return this;
   }

   public void addColumn(String columnName, java.util.function.Function<java.util.LinkedHashMap<String,Object>,Object> function)
   {
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;
      for (ArrayList<Object> row : this.table)
      {
         java.util.LinkedHashMap<String,Object> map = new java.util.LinkedHashMap<>();
         for (String key : columnMap.keySet())
         {
            map.put(key, row.get(columnMap.get(key)));
         }
         Object result = function.apply(map);
         row.add(result);
      }
      this.columnMap.put(columnName, newColumnNumber);
   }

   public PlayerTable filter(Predicate< Player > predicate)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         if (predicate.test(start))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public PlayerTable filterRow(Predicate<LinkedHashMap<String,Object> > predicate)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         LinkedHashMap<String,Object> map = new LinkedHashMap< >();
         for (String key : columnMap.keySet())
         {
            map.put(key, row.get(columnMap.get(key)));
         }
         if (predicate.test(map))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public LinkedHashSet< Player > toSet()
   {
      LinkedHashSet< Player > result = new LinkedHashSet<>();
      for (ArrayList row : this.table)
      {
         Player value = (Player) row.get(columnMap.get(columnName));
         result.add(value);
      }
      return result;
   }

   public String toString()
   {
      StringBuilder buf = new StringBuilder();
      for (String key : columnMap.keySet())
      {
         buf.append(key).append(" \t");
      }
      buf.append("\n");
      for (ArrayList<Object> row : table)
      {
         for (Object cell : row)
         {
            buf.append(cell).append(" \t");
         }
         buf.append("\n");
      }
      buf.append("\n");
      return buf.toString();
   }


   public SectionTable expandSections(String... rowName)
   {
      SectionTable result = new SectionTable();
      result.setColumnMap(this.columnMap);
      result.setTable(table);
      int newColumnNumber = this.table.size() > 0 ? this.table.get(0).size() : 0;

      String newColumnName = rowName != null && rowName.length > 0 ? rowName[0] : "" + ((char)('A' + newColumnNumber));
      result.setColumnName(newColumnName);
      columnMap.put(newColumnName, newColumnNumber);

      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         for (Section current : start.getSections())
         {
            ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
            newRow.add(current);
            this.table.add(newRow);
         }
      }
      return result;
   }

   public PlayerTable hasSections(SectionTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Player start = (Player) row.get(columnMap.get(this.getColumnName()));
         Section other = (Section) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getSections().contains(other))
         {
            this.table.add(row);
         }
      }
      return this;
   }

}