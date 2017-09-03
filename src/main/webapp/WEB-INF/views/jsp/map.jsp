<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="search-header.jsp"/>

<style>

    html, body {
        height: 100vh;
        overflow-y: hidden;
    }

    #map {
        height: 100vh;
        width: 100%;
    }

    #drop-down-panel {
        margin-bottom: 3px;
        height: 64px;
        padding: 10px;
    }

    .no-mar-bot {
        margin-top: 4px;
        margin-bottom: 0;
    }

</style>

<div id="main">

    <div class="row" id="drop-down-panel">
        <div class="col m8 s12">
            <div class="row no-mar-bot">
                <div class="input-field col s4">
                    <select id="type-select">
                        <option value="" disabled selected>Choose a type</option>
                        <option value="wind">Wind</option>
                        <option value="solar">Solar</option>
                    </select>
                    <label>Type</label>
                </div>
                <div class="input-field col s4">
                    <select id="state-select">
                        <option value="" disabled selected>Select state</option>
                    </select>
                    <label>State</label>
                </div>
                <div class="input-field col s4">
                    <select id="plant-select">
                        <option value="" disabled selected>Select a plant</option>
                    </select>
                    <label>Plant</label>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col s12 no-pad">
            <div id="map">
                <div class="valign-wrapper" style="height: 75%">
                    <div class="center-align col s12">
                        <h5>Loading map...</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    function updateStateDropDown(data) {
        const stateDropDownEl = $('#state-select');
        console.log(data);
        stateDropDownEl.html('<option value="" disabled selected>Select a state</option>');
        $('#plant-select').html('<option value="" disabled selected>Select a plant</option>');
        data.forEach((state) => {
            let currentStateEl = '<option value="' + state.state_id + '">' + state.state_name + '</option>';
            console.log(currentStateEl);
            stateDropDownEl.append(currentStateEl);
        });
        $('select').material_select();
    }

    function updatePlantDropDown(data) {
        const plantDropDownEl = $('#plant-select');
        plantDropDownEl.html('<option value="" disabled selected>Select a plant</option>');
        const typeVal = $('#type-select').val();
        console.log(data);
        data.forEach((plant) => {
            let currentPlantEl = "";
            if (typeVal === 'solar')
                currentPlantEl = '<option value="' + plant.s_plant_id + '">' + plant.s_plant_name + '</option>';
            else if (typeVal === 'wind')
                currentPlantEl = '<option value="' + plant.w_plant_id + '">' + plant.w_plant_name + '</option>';
            plantDropDownEl.append(currentPlantEl);
        });
        $('select').material_select();
        plantDropDownEl.on('change', plantListChangeEventListener.bind(plantDropDownEl, typeVal));
    }

    function plantListChangeEventListener(type) {
        const id = this.val();
        window.location = '/plant/' + type + '/' + id + '/';
    }

    $(document).ready(function () {
        $('select').material_select();

        $("#type-select").on('change', (e) => {
            let type = $("#type-select").val();
            $.ajax('/map/plant/' + type + '/', {
                success: updateStateDropDown
            });
        });

        $('#state-select').on('change', (e) => {
            let type = $("#type-select").val();
            let stateId = $('#state-select').val();
            $.ajax('/map/plant/' + type + '/' + stateId + '/', {
                success: updatePlantDropDown
            });
        });
    });

    function init() {
        $.ajax('/map/all/', {
            success: initMap
        });
    }

    function initMap(data) {
        const centerOfIndia = {lat: 20.146633, lng: 79.088860};
        const map = new google.maps.Map(document.getElementById('map'), {
            zoom: 5,
            center: centerOfIndia
        });

        data.forEach((plant) => {
            const icons = {
                solar: {
                    url: '/resources/images/solarplant-small.png',
//                    size: new google.maps.Size(64, 64),
//                    origin: new google.maps.Point(0, 0),
//                    anchor: new google.maps.Point(0, 32)
                },
                wind: {
                    url: '/resources/images/windplant-small.png',
//                    size: new google.maps.Size(64, 64),
//                    origin: new google.maps.Point(0, 0),
//                    anchor: new google.maps.Point(0, 32)
                }
            };
            let pos = {lat: plant.plant_lat, lng: plant.plant_lon};
            const marker = new google.maps.Marker({
                position: pos,
                map: map,
                title: plant.plant_name,
                icon: icons[plant.plant_type]
            });
            marker.addListener('click', () => {
                window.location = '/plant/' + plant.plant_type + '/' + plant.plant_id + '/';
            });
        });
    }

</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBg5xtZ_EjAIBNmBVA-kPmUM9SeasV8Kxs&callback=init">
</script>

<jsp:include page="footer.jsp"/>
