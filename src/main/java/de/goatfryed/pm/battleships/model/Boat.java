package de.goatfryed.pm.battleships.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Boat  
{

   public static final String PROPERTY_type = "type";

   private String type;

   public String getType()
   {
      return type;
   }

   public Boat setType(String value)
   {
      if (value == null ? this.type != null : ! value.equals(this.type))
      {
         String oldValue = this.type;
         this.type = value;
         firePropertyChange("type", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_player = "player";

   private Player player = null;

   public Player getPlayer()
   {
      return this.player;
   }

   public Boat setPlayer(Player value)
   {
      if (this.player != value)
      {
         Player oldValue = this.player;
         if (this.player != null)
         {
            this.player = null;
            oldValue.withoutBoats(this);
         }
         this.player = value;
         if (value != null)
         {
            value.withBoats(this);
         }
         firePropertyChange("player", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Section> EMPTY_sections = new java.util.ArrayList<Section>()
   { @Override public boolean add(Section value){ throw new UnsupportedOperationException("No direct add! Use xy.withSections(obj)"); }};


   public static final String PROPERTY_sections = "sections";

   private java.util.ArrayList<Section> sections = null;

   public java.util.ArrayList<Section> getSections()
   {
      if (this.sections == null)
      {
         return EMPTY_sections;
      }

      return this.sections;
   }

   public Boat withSections(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withSections(i);
            }
         }
         else if (item instanceof Section)
         {
            if (this.sections == null)
            {
               this.sections = new java.util.ArrayList<Section>();
            }
            if ( ! this.sections.contains(item))
            {
               this.sections.add((Section)item);
               ((Section)item).setBoat(this);
               firePropertyChange("sections", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Boat withoutSections(Object... value)
   {
      if (this.sections == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutSections(i);
            }
         }
         else if (item instanceof Section)
         {
            if (this.sections.contains(item))
            {
               this.sections.remove((Section)item);
               ((Section)item).setBoat(null);
               firePropertyChange("sections", item, null);
            }
         }
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

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getType());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setPlayer(null);

      this.withoutSections(this.getSections().clone());


   }


}