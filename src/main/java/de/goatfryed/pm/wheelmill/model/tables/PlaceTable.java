package de.goatfryed.pm.wheelmill.model.tables;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import de.goatfryed.pm.wheelmill.model.Place;

import de.goatfryed.pm.wheelmill.model.Game;

import de.goatfryed.pm.wheelmill.model.Stone;

import de.goatfryed.pm.wheelmill.model.Diagonal;

import java.util.Arrays;

import java.util.function.Predicate;

import java.util.LinkedHashSet;

public class PlaceTable 
{

   public PlaceTable(Place... start)
   {
      this.setColumnName("Place");
      columnMap.put(this.getColumnName(), 0);
      for (Place current : start)
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

   public PlaceTable setTable(ArrayList<ArrayList<Object>> value)
   {
      this.table = value;
      return this;
   }


   private String columnName = null;

   public String getColumnName()
   {
      return columnName;
   }

   public PlaceTable setColumnName(String value)
   {
      this.columnName = value;
      return this;
   }


   private LinkedHashMap<String, Integer> columnMap = new LinkedHashMap<>();

   public LinkedHashMap<String, Integer> getColumnMap()
   {
      return columnMap;
   }

   public PlaceTable setColumnMap(LinkedHashMap<String, Integer> value)
   {
      this.columnMap = value;
      return this;
   }


   public GameTable expandCenterOf(String... rowName)
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
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getCenterOf());
         this.table.add(newRow);
      }
      return result;
   }

   public PlaceTable hasCenterOf(GameTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         Game other = (Game) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getCenterOf() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public StoneTable expandOccupiedBy(String... rowName)
   {
      StoneTable result = new StoneTable();
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
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getOccupiedBy());
         this.table.add(newRow);
      }
      return result;
   }

   public PlaceTable hasOccupiedBy(StoneTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         Stone other = (Stone) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getOccupiedBy() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public PlaceTable expandCW(String... rowName)
   {
      PlaceTable result = new PlaceTable();
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
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getCW());
         this.table.add(newRow);
      }
      return result;
   }

   public PlaceTable hasCW(PlaceTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         Place other = (Place) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getCW() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public PlaceTable expandCCW(String... rowName)
   {
      PlaceTable result = new PlaceTable();
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
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getCCW());
         this.table.add(newRow);
      }
      return result;
   }

   public PlaceTable hasCCW(PlaceTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         Place other = (Place) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getCCW() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public DiagonalTable expandOnDiagonal(String... rowName)
   {
      DiagonalTable result = new DiagonalTable();
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
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getOnDiagonal());
         this.table.add(newRow);
      }
      return result;
   }

   public PlaceTable hasOnDiagonal(DiagonalTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         Diagonal other = (Diagonal) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getOnDiagonal() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public PlaceTable selectColumns(String... columnNames)
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

   public PlaceTable dropColumns(String... columnNames)
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

   public PlaceTable filter(Predicate< Place > predicate)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Place start = (Place) row.get(columnMap.get(this.getColumnName()));
         if (predicate.test(start))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public PlaceTable filterRow(Predicate<LinkedHashMap<String,Object> > predicate)
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

   public LinkedHashSet< Place > toSet()
   {
      LinkedHashSet< Place > result = new LinkedHashSet<>();
      for (ArrayList row : this.table)
      {
         Place value = (Place) row.get(columnMap.get(columnName));
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