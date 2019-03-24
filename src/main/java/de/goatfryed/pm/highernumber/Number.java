package de.goatfryed.pm.highernumber;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Number 
{

   public static final String PROPERTY_value = "value";

   private double value;

   public double getValue()
   {
      return value;
   }

   public Number setValue(double value)
   {
      if (value != this.value)
      {
         double oldValue = this.value;
         this.value = value;
         firePropertyChange("value", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_pickedBy = "pickedBy";

   private Player pickedBy = null;

   public Player getPickedBy()
   {
      return this.pickedBy;
   }

   public Number setPickedBy(Player value)
   {
      if (this.pickedBy != value)
      {
         Player oldValue = this.pickedBy;
         if (this.pickedBy != null)
         {
            this.pickedBy = null;
            oldValue.setPicked(null);
         }
         this.pickedBy = value;
         if (value != null)
         {
            value.setPicked(this);
         }
         firePropertyChange("pickedBy", oldValue, value);
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
      this.setPickedBy(null);

   }


}