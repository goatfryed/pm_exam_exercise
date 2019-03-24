package de.goatfryed.pm.foxAndGeese.model.tables;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import de.goatfryed.pm.foxAndGeese.model.Field;

import de.goatfryed.pm.foxAndGeese.model.Meeple;

import java.util.Arrays;

import java.util.function.Predicate;

import java.util.LinkedHashSet;

public class FieldTable 
{

   public FieldTable(Field... start)
   {
      this.setColumnName("Field");
      columnMap.put(this.getColumnName(), 0);
      for (Field current : start)
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

   public FieldTable setTable(ArrayList<ArrayList<Object>> value)
   {
      this.table = value;
      return this;
   }


   private String columnName = null;

   public String getColumnName()
   {
      return columnName;
   }

   public FieldTable setColumnName(String value)
   {
      this.columnName = value;
      return this;
   }


   private LinkedHashMap<String, Integer> columnMap = new LinkedHashMap<>();

   public LinkedHashMap<String, Integer> getColumnMap()
   {
      return columnMap;
   }

   public FieldTable setColumnMap(LinkedHashMap<String, Integer> value)
   {
      this.columnMap = value;
      return this;
   }


   public MeepleTable expandMeeple(String... rowName)
   {
      MeepleTable result = new MeepleTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getMeeple());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasMeeple(MeepleTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Meeple other = (Meeple) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getMeeple() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandSouth(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getSouth());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasSouth(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getSouth() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandNorth(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getNorth());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasNorth(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getNorth() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandWest(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getWest());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasWest(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getWest() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandEast(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getEast());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasEast(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getEast() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandNortheast(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getNortheast());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasNortheast(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getNortheast() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandSouthwest(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getSouthwest());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasSouthwest(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getSouthwest() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandNorthwest(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getNorthwest());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasNorthwest(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getNorthwest() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable expandSoutheast(String... rowName)
   {
      FieldTable result = new FieldTable();
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
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         ArrayList<Object> newRow = (ArrayList<Object>) row.clone();
         newRow.add(start.getSoutheast());
         this.table.add(newRow);
      }
      return result;
   }

   public FieldTable hasSoutheast(FieldTable rowName)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         Field other = (Field) row.get(columnMap.get(rowName.getColumnName()));
         if (start.getSoutheast() == other)
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable selectColumns(String... columnNames)
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

   public FieldTable dropColumns(String... columnNames)
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

   public FieldTable filter(Predicate< Field > predicate)
   {
      ArrayList<ArrayList<Object> > oldTable = (ArrayList<ArrayList<Object> >) this.table.clone();
      this.table.clear();
      for (ArrayList<Object> row : oldTable)
      {
         Field start = (Field) row.get(columnMap.get(this.getColumnName()));
         if (predicate.test(start))
         {
            this.table.add(row);
         }
      }
      return this;
   }

   public FieldTable filterRow(Predicate<LinkedHashMap<String,Object> > predicate)
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

   public LinkedHashSet< Field > toSet()
   {
      LinkedHashSet< Field > result = new LinkedHashSet<>();
      for (ArrayList row : this.table)
      {
         Field value = (Field) row.get(columnMap.get(columnName));
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