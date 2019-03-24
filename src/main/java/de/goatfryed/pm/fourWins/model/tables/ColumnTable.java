package de.goatfryed.pm.fourWins.model.tables;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import de.goatfryed.pm.fourWins.model.Column;

import de.goatfryed.pm.fourWins.model.Game;

import de.goatfryed.pm.fourWins.model.Token;

import java.util.Arrays;

import java.util.function.Predicate;

import java.util.LinkedHashSet;

public class ColumnTable 
{

   public ColumnTable(Column... start)
   {
      this.setColumnName("Column");
      columnMap.put(this.getColumnName(), 0);
      for (Column current : start)
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

   public ColumnTable setTable(ArrayList<ArrayList<Object>> value)
   {
      this.table = value;
      return this;
   }


   private String columnName = null;

   public String getColumnName()
   {
      return columnName;
   }

   public ColumnTable setColumnName(String value)
   {
      this.columnName = value;
      return this;
   }


   private LinkedHashMap<String, Integer> columnMap = new LinkedHashMap<>();

   public LinkedHashMap<String, Integer> getColumnMap()
   {
      return columnMap;
   }

   public ColumnTable setColumnMap(LinkedHashMap<String, Integer> value)
   {
      this.columnMap = value;
      return this;
   }


   public intTable expandId(String... rowName)
   {
      intTable result = new intTable();
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
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getId());
         this.table.add(newRow);
      }
      return result;
   }

   public intTable expandMaxHeight(String... rowName)
   {
      intTable result = new intTable();
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
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getMaxHeight());
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
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getGame());
         this.table.add(newRow);
      }
      return result;
   }

   public ColumnTable hasGame(GameTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         Game other = (Game) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getGame() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public TokenTable expandTokens(String... rowName)
   {
      TokenTable result = new TokenTable();
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
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         for (Token current : start.getTokens())
         {
            ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
            newRow.add(current);
            this.table.add(newRow);
         }
      }
      return result;
   }

   public ColumnTable hasTokens(TokenTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         Token other = (Token) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getTokens().contains(other))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public ColumnTable expandLeft(String... rowName)
   {
      ColumnTable result = new ColumnTable();
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
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getLeft());
         this.table.add(newRow);
      }
      return result;
   }

   public ColumnTable hasLeft(ColumnTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         Column other = (Column) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getLeft() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public ColumnTable expandRight(String... rowName)
   {
      ColumnTable result = new ColumnTable();
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
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getRight());
         this.table.add(newRow);
      }
      return result;
   }

   public ColumnTable hasRight(ColumnTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         Column other = (Column) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getRight() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public ColumnTable selectColumns(String... columnNames)
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

   public ColumnTable dropColumns(String... columnNames)
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

   public ColumnTable filter(Predicate< Column > predicate)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Column start = (Column) row.get(columnMap.get(this.getColumnName()));
         if (predicate.test(start))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public ColumnTable filterRow(Predicate<LinkedHashMap<String,Object> > predicate)
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

   public LinkedHashSet< Column > toSet()
   {
      LinkedHashSet< Column > result = new LinkedHashSet<>();
      for (ArrayList row : this.table)
      {
         Column value = (Column) row.get(columnMap.get(columnName));
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


}