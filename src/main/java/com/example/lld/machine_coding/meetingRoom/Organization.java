//package com.example.lld.machine_coding.main;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Organization {
//    private Integer id;
////    private final List<Building> buildingList;
//    private Integer lunchStartHour; // 3
//    private Integer lunchEndHour; // 4
//
//    // each build = 4 floor
//    // each floor = 5 room
//
//    public Organization(int id,int numberOfBuilding, int lunchStartHour, int lunchEndHour) {
//        this.id = id;
//        this.buildingList = new ArrayList<>(numberOfBuilding);
//        for (int i = 0; i < numberOfBuilding; i++) {
//            Building building = new Building(i, 4);
//            this.buildingList.add(building);
//        }
//        this.lunchEndHour =
//    }
//
//    public List<String> getAvailableRooms(Integer floorId, Integer buildingId, Long startTime, Long endTime) {
//        if (buildingId == null) {
//            return null;
//        }
//        if (startTime == null) {
//            startTime = System.currentTimeMillis();
//        }
//        if (endTime == null) {
//            endTime = startTime + 60 * 60 * 1000;
//        }
//        List<String> availableRooms = new ArrayList<>();
//        Date current = new Date();
//        Date date = new Date(current.ge);
//        if (startTime > 2 && endTime > 1) {
//            throw new CustomException("");
//        }
//        if (startTime - endTime > 6){
//            throw new CustomException("");
//        }
//        Building building = this.buildingList.get(buildingId);
//        if (floorId == null) {
//            for (Floor floor : building.getFloorList()) {
//                for (Room room : floor.getRoomList()) {
//                    if (startTime > room.endTime || endTime < room.startTime) {
//                        availableRooms.add(room.id + "_" + floor.id + "_" + buildingId);
//                    }
//                }
//            }
//        } else {
//            Floor floor = building.getFloorList().get(floorId);
//            for (Room room : floor.getRoomList()) {
//                if (startTime > room.endTime || endTime < room.startTime) {
//                    availableRooms.add(room.id + "_" + floorId + "_" + buildingId);
//                }
//            }
//        }
//        return availableRooms;
//    }
////    1_2_1 - 1-2
////    1_2_1 - 3-4
//
//
//    public void bookRoom(Long startTime, Long endTime, String room_floor_building) {
//        String[] roomId = room_floor_building.split("_");
//        synchronized (room_floor_building) {
//            Room room =
//                buildingList.get(Integer.parseInt(roomId[2])).getFloorList().get(Integer.parseInt(roomId[1])).getRoomList().get(Integer.parseInt(roomId[0]));
//            if ((room.endTime == null || startTime > room.endTime) && (room.startTime == null || endTime < room.startTime)) {
//                availableRooms.add(room.id + "_" + floorId + "_" + buildingId);
//            }
//        }
//    }
//
//    private static class Building {
//        private final List<Floor> floorList;
//        private Integer id;
//
//        public Building(int id, int numberOfFloor) {
//            this.floorList = new ArrayList<>(numberOfFloor);
//            for (int i = 0; i < numberOfFloor; i++) {
//                Floor floor = new Floor(i, 5);
//                this.floorList.add(floor);
//            }
//        }
//
//        public List<Floor> getFloorList() {
//            return this.floorList;
//        }
//    }
//
//    private static class Floor {
//        private final List<Room> roomList;
//        private Integer id;
//
//        public Floor(int id, int numberOfRoom) {
//            this.id = id;
//            this.roomList = new ArrayList<>(numberOfRoom);
//            for (int i = 0; i < numberOfRoom; i++) {
//                Room room = new Room(i, null, null);
//                this.roomList.add(room);
//            }
//        }
//
//        public List<Room> getRoomList() {
//            return this.roomList;
//        }
//    }
//
//    private static class Room {
//
//        final Integer id;
//        final Integer floorId;
//        final Integer build
//            List<Meeting>
//
//        public Room(int id, Long startTime, Long endTime) {
//            this.id = id;
//        }
//    }
//
//}
