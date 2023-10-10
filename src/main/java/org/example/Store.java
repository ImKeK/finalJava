package org.example;

import java.util.*;
import java.io.IOException;;

public class Store {
    private List<Raffle> raffles;

    private List<Lot> products;
    public Store() {
        products = new ArrayList<>();
        raffles = new ArrayList<>();
    }

    public List<Lot> getProducts() {
        return products;
    }

    public List<Raffle> getRaffles() {
        return raffles;
    }

    public void addRaffle(Raffle raffle){
        if(raffle !=null){
            raffles.add(raffle);
        }

    }
    public void addLot(Lot lot) {
        products.add(lot);
    }

    public void removeLot(Lot lot) {
        if (products.contains(lot)) products.remove(lot);
    }

    public void clearProducts(){
        if(products==null)
            products=new ArrayList<>();
        else
            products.clear();
    }

    public void removeLottery(Raffle raffle){
        if(raffles !=null && raffles.contains(raffle)){
            raffles.remove(raffle);
        }
    }

    public void clearLotteries(){
        if(raffles ==null)
            raffles =new ArrayList<>();
        else
            raffles.clear();
    }


    public void saveProducts(String pathToFile) {
        try (LofIO<ArrayList<Lot>> disk = new LofIO<>()) {
            disk.writeObjectToFile(products, pathToFile);
            System.out.println("Данные успешно сохранены.");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить коллекцию товаров магазина. ( " + e.getMessage() + " )");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так! ( " + e.getMessage() + " )");
        }
    }

    public void readProducrts(String pathToFile) {
        try (LofIO<ArrayList<Lot>> disk = new LofIO<>()) {
            products = (ArrayList<Lot>) disk.readObjectFromFile(pathToFile);
        } catch (ClassNotFoundException e) {
            System.out.println("Коллекция товаров магазина не найдена. (" + " " + e.getMessage() + " )");
        } catch (IOException e) {
            System.out.println("Не удалось считать коллекцию товаров магазина. (" + " " + e.getMessage() + " )");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так! ( " + e.getMessage() + " )");
        }
    }
    public void printProducts(){
        if(products==null){
            products=new ArrayList<>();
            System.out.println("Коллекция товаров пуста.");
        }else {
            if(products.isEmpty()){
                System.out.println("Коллекция товаров пуста.");
            }else {
                for(Lot lot:products){
                    System.out.println(lot.toString());
                }
            }
        }
    }
    public void saveRaffle(String pathToFile) {
        try (LofIO<ArrayList<Raffle>> disk = new LofIO<>()) {
            disk.writeObjectToFile(raffles, pathToFile);
        } catch (IOException e) {
            System.out.println("Не удалось сохранить коллекцию лотерей магазина. ( " + e.getMessage() + " )");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так! ( " + e.getMessage() + " )");
        }
    }
    public void readRaffle(String pathToFile) {
        try (LofIO<ArrayList<Raffle>> disk = new LofIO<>()) {
            raffles = (ArrayList<Raffle>) disk.readObjectFromFile(pathToFile);
        } catch (ClassNotFoundException e) {
            System.out.println("Коллекция лотерей не найдена. (" + " " + e.getMessage() + " )");
        } catch (IOException e) {
            System.out.println("Не удалось считать коллекцию лотерей. (" + " " + e.getMessage() + " )");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так! ( " + e.getMessage() + " )");
        }
    }
    public int createId() {
        Date currentDate = new Date();
        long timestamp = currentDate.getTime();
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        int[] uniqueHod = new int[]{(int) (timestamp + randomNumber)};
        Optional<Lot> searchProduct = products.stream().filter(product -> product.getId() == uniqueHod[0]).findFirst();
        while (searchProduct.isPresent()) {
            randomNumber = random.nextInt(1000);
            uniqueHod[0] = (int) (timestamp + randomNumber);
            searchProduct = products.stream().filter(product -> product.getId() == uniqueHod[0]).findFirst();
        }
        return uniqueHod[0];
    }}
