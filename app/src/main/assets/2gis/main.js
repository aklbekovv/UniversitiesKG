var map;

DG.then(function () {
    map = DG.map('map', {
        center: [54.98, 82.89],
        zoom: 13,
        zoomControl: false,
        fullscreenControl: false,
    });

    map.panTo([54.98, 82.89])

    DG.marker([54.98, 82.89]).addTo(map).bindPopup('You have clicked on me!');
});