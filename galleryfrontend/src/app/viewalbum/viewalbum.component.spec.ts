import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewalbumComponent } from './viewalbum.component';

describe('ViewalbumComponent', () => {
  let component: ViewalbumComponent;
  let fixture: ComponentFixture<ViewalbumComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewalbumComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewalbumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
