package com.example.helloworld.resources;
import com.example.helloworld.api.Saying;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class HelloWorldService {
    @JsonProperty
    private  String template="Hello, %s!";
    final List<Saying> link=new ArrayList<>();
    public AtomicLong counter =new AtomicLong();
    public HelloWorldService(){

        final String value = String.format(template, "Aphiwe");
        link.add(new Saying(counter.incrementAndGet(), value));
        final String value2 = String.format(template, "Sanele");
        link.add(new Saying(counter.incrementAndGet(), value2));
        final String value3 = String.format(template, "Siviwe");
        link.add(new Saying(counter.incrementAndGet(), value3));
        final String value4 = String.format(template, "Thebela");
        link.add(new Saying(counter.incrementAndGet(), value4));
    }

    public   List<Saying> getHellos(){

        return link;
    }
    public   void addhello(Saying S){
        final String valuev = String.format(template, S.getContent());
        link.add(new Saying(counter.incrementAndGet(), valuev));
    }
    public void putHello(int id, Saying S){
        for(Saying s:link){
            if(id==s.getId()){
                final String valuev = String.format(template, S.getContent());
                s.setContent(valuev);

               }

        }

    }
    public void deleleHello(int id){
        for(Saying s:link){
            if(id==s.getId()){
                link.remove(s);
            }

        }

    }


}
