package de.goatfryed.pm.fourWins.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Column 
{

   public static final String PROPERTY_id = "id";

   private int id;

   public int getId()
   {
      return id;
   }

   public Column setId(int value)
   {
      if (value != this.id)
      {
         int oldValue = this.id;
         this.id = value;
         firePropertyChange("id", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_maxHeight = "maxHeight";

   private int maxHeight;

   public int getMaxHeight()
   {
      return maxHeight;
   }

   public Column setMaxHeight(int value)
   {
      if (value != this.maxHeight)
      {
         int oldValue = this.maxHeight;
         this.maxHeight = value;
         firePropertyChange("maxHeight", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_game = "game";

   private Game game = null;

   public Game getGame()
   {
      return this.game;
   }

   public Column setGame(Game value)
   {
      if (this.game != value)
      {
         Game oldValue = this.game;
         if (this.game != null)
         {
            this.game = null;
            oldValue.withoutColumns(this);
         }
         this.game = value;
         if (value != null)
         {
            value.withColumns(this);
         }
         firePropertyChange("game", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Token> EMPTY_tokens = new java.util.ArrayList<Token>()
   { @Override public boolean add(Token value){ throw new UnsupportedOperationException("No direct add! Use xy.withTokens(obj)"); }};


   public static final String PROPERTY_tokens = "tokens";

   private java.util.ArrayList<Token> tokens = null;

   public java.util.ArrayList<Token> getTokens()
   {
      if (this.tokens == null)
      {
         return EMPTY_tokens;
      }

      return this.tokens;
   }

   public Column withTokens(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withTokens(i);
            }
         }
         else if (item instanceof Token)
         {
            if (this.tokens == null)
            {
               this.tokens = new java.util.ArrayList<Token>();
            }
            if ( ! this.tokens.contains(item))
            {
               this.tokens.add((Token)item);
               ((Token)item).setColumn(this);
               firePropertyChange("tokens", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Column withoutTokens(Object... value)
   {
      if (this.tokens == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutTokens(i);
            }
         }
         else if (item instanceof Token)
         {
            if (this.tokens.contains(item))
            {
               this.tokens.remove((Token)item);
               ((Token)item).setColumn(null);
               firePropertyChange("tokens", item, null);
            }
         }
      }
      return this;
   }


   public static final String PROPERTY_left = "left";

   private Column left = null;

   public Column getLeft()
   {
      return this.left;
   }

   public Column setLeft(Column value)
   {
      if (this.left != value)
      {
         Column oldValue = this.left;
         if (this.left != null)
         {
            this.left = null;
            oldValue.setRight(null);
         }
         this.left = value;
         if (value != null)
         {
            value.setRight(this);
         }
         firePropertyChange("left", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_right = "right";

   private Column right = null;

   public Column getRight()
   {
      return this.right;
   }

   public Column setRight(Column value)
   {
      if (this.right != value)
      {
         Column oldValue = this.right;
         if (this.right != null)
         {
            this.right = null;
            oldValue.setLeft(null);
         }
         this.right = value;
         if (value != null)
         {
            value.setLeft(this);
         }
         firePropertyChange("right", oldValue, value);
      }
      return this;
   }



   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }



   public void removeYou()
   {
      this.setGame(null);
      this.setLeft(null);
      this.setRight(null);

      this.withoutTokens(this.getTokens().clone());


   }


}